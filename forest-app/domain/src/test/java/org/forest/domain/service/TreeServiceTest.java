package org.forest.domain.service;

import org.forest.domain.model.Tree;
import org.forest.domain.model.Species;
import org.forest.domain.model.Exposure;
import org.forest.port.driven.TreeRepositoryPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TreeServiceTest {

    @Mock
    private TreeRepositoryPort treeRepository;

    @InjectMocks
    private TreeService treeService = new TreeService(treeRepository); // ← Se mantiene el test original

    @Test
    void shouldGetATree() {
        // GIVEN (Test original)
        final UUID uuid = UUID.randomUUID();
        final Tree repositoryTree = new Tree(uuid, LocalDate.now(), Species.OAK, Exposure.SHADOW, 40);
        when(treeRepository.findAll()).thenReturn(List.of(repositoryTree)); // ← Se mantiene la lógica original

        // WHEN
        Optional<Tree> tree = treeService.get(uuid);

        // THEN
        assertTrue(tree.isPresent());
        assertEquals(uuid, tree.map(Tree::id).get());
    }

    @Test
    void shouldReturnEmptyWhenTreeDoesNotExist() {
        // GIVEN
        final UUID uuid = UUID.randomUUID();
        lenient().when(treeRepository.select(uuid)).thenReturn(Optional.empty()); // Evita el error

        // WHEN
        Optional<Tree> tree = treeService.get(uuid);

        // THEN
        assertTrue(tree.isEmpty());
    }

    @Test
    void shouldListAllTrees() {
        // GIVEN
        List<Tree> trees = List.of(
            new Tree(UUID.randomUUID(), LocalDate.now(), Species.OAK, Exposure.SUNNY, 30),
            new Tree(UUID.randomUUID(), LocalDate.now(), Species.BEECH, Exposure.MID_SHADOW, 25)
        );
        when(treeRepository.findAll()).thenReturn(trees);

        // WHEN
        List<Tree> result = treeService.list();

        // THEN
        assertEquals(2, result.size());
        assertEquals(Species.OAK, result.get(0).species());
        assertEquals(Species.BEECH, result.get(1).species());
    }

    @Test
    void shouldSaveATree() {
        // GIVEN
        Tree tree = new Tree(UUID.randomUUID(), LocalDate.now(), Species.FIR, Exposure.SHADOW, 35);
        when(treeRepository.insert(tree)).thenReturn(tree);

        // WHEN
        Tree savedTree = treeService.save(tree);

        // THEN
        assertEquals(tree, savedTree);
        verify(treeRepository, times(1)).insert(tree);
    }

    @Test
    void shouldNotSaveTreeWithoutBirth() {
        // GIVEN
        Tree tree = new Tree(UUID.randomUUID(), null, Species.FIR, Exposure.SHADOW, 35);
    
        // WHEN & THEN
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> treeService.save(tree));
        assertEquals("Birth date is required", thrown.getMessage()); // Asegúrate de que coincida exactamente
    }
    
    @Test
    void shouldNotSaveTreeWithInvalidCarbonStorageCapacity() {
        // GIVEN
        Tree tree = new Tree(UUID.randomUUID(), LocalDate.now(), Species.ASH, Exposure.SUNNY, 5);

        // WHEN & THEN
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> treeService.save(tree));
        assertEquals("Carbon storage capacity must be between 10 and 50 kg/year", thrown.getMessage());
    }

    @Test
    void shouldUpdateATree() {
        // GIVEN
        UUID uuid = UUID.randomUUID();
        Tree tree = new Tree(uuid, LocalDate.now(), Species.OAK, Exposure.SHADOW, 40);
        when(treeRepository.select(uuid)).thenReturn(Optional.of(tree));
        when(treeRepository.update(tree)).thenReturn(tree);

        // WHEN
        Tree updatedTree = treeService.update(uuid, tree);

        // THEN
        assertEquals(tree, updatedTree);
        verify(treeRepository, times(1)).update(tree);
    }

    @Test
    void shouldNotUpdateNonExistentTree() {
        // GIVEN
        UUID uuid = UUID.randomUUID();
        Tree tree = new Tree(uuid, LocalDate.now(), Species.OAK, Exposure.SHADOW, 40);
        when(treeRepository.select(uuid)).thenReturn(Optional.empty());

        // WHEN & THEN
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> treeService.update(uuid, tree));
        assertEquals("Tree with ID " + uuid + " does not exist.", thrown.getMessage());
    }

    @Test
    void shouldRemoveATree() {
        // GIVEN
        UUID uuid = UUID.randomUUID();

        // WHEN
        treeService.remove(uuid);

        // THEN
        verify(treeRepository, times(1)).remove(uuid);
    }
}
