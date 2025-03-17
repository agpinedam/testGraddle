package org.forest.domain.service;

import org.forest.domain.model.Forest;
import org.forest.domain.model.ForestType;
import org.forest.domain.model.Tree;
import org.forest.port.driven.ForestRepositoryPort;
import org.forest.port.driven.TreeRepositoryPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ForestServiceTest {

    @Mock
    private ForestRepositoryPort forestRepository;

    @Mock
    private TreeRepositoryPort treeRepository;

    @InjectMocks
    private ForestService forestService;

    @Test
    void shouldCreateForest() {
        // GIVEN
        UUID treeId1 = UUID.randomUUID();
        UUID treeId2 = UUID.randomUUID();
        Tree tree1 = new Tree(treeId1, null, null, null, 20);
        Tree tree2 = new Tree(treeId2, null, null, null, 30);

        Forest forest = new Forest(UUID.randomUUID(), ForestType.TEMPERATE, List.of(tree1, tree2), 100);
        
        when(treeRepository.select(treeId1)).thenReturn(Optional.of(tree1));
        when(treeRepository.select(treeId2)).thenReturn(Optional.of(tree2));
        when(forestRepository.insert(forest)).thenReturn(forest);

        // WHEN
        Forest createdForest = forestService.createForest(forest);

        // THEN
        assertNotNull(createdForest);
        assertEquals(forest, createdForest);
        verify(forestRepository, times(1)).insert(forest);
    }

    @Test
    void shouldNotCreateForestWithNonExistentTree() {
        // GIVEN
        UUID nonExistentTreeId = UUID.randomUUID();
        Tree tree = new Tree(nonExistentTreeId, null, null, null, 20);
        Forest forest = new Forest(UUID.randomUUID(), ForestType.TROPICAL, List.of(tree), 50);

        when(treeRepository.select(nonExistentTreeId)).thenReturn(Optional.empty());

        // WHEN & THEN
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> forestService.createForest(forest));
        assertEquals("Tree with ID " + nonExistentTreeId + " does not exist.", thrown.getMessage());
    }

    @Test
    void shouldNotCreateForestWithZeroSurface() {
        // GIVEN
        UUID treeId = UUID.randomUUID();
        Tree tree = new Tree(treeId, null, null, null, 20);
        Forest forest = new Forest(UUID.randomUUID(), ForestType.BOREAL, List.of(tree), 0);

        when(treeRepository.select(treeId)).thenReturn(Optional.of(tree));

        // WHEN & THEN
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> forestService.createForest(forest));
        assertEquals("Forest surface must be positive.", thrown.getMessage());
    }

    @Test
    void shouldGetForest() {
        // GIVEN
        UUID forestId = UUID.randomUUID();
        Forest forest = new Forest(forestId, ForestType.TEMPERATE, List.of(), 100);

        when(forestRepository.select(forestId)).thenReturn(Optional.of(forest));

        // WHEN
        Optional<Forest> result = forestService.getForest(forestId);

        // THEN
        assertTrue(result.isPresent());
        assertEquals(forest, result.get());
    }

    @Test
    void shouldReturnEmptyWhenForestDoesNotExist() {
        // GIVEN
        UUID forestId = UUID.randomUUID();
        when(forestRepository.select(forestId)).thenReturn(Optional.empty());

        // WHEN
        Optional<Forest> result = forestService.getForest(forestId);

        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void shouldListAllForests() {
        // GIVEN
        List<Forest> forests = List.of(
            new Forest(UUID.randomUUID(), ForestType.TEMPERATE, List.of(), 100),
            new Forest(UUID.randomUUID(), ForestType.BOREAL, List.of(), 200)
        );
        when(forestRepository.selectAll()).thenReturn(forests);

        // WHEN
        List<Forest> result = forestService.listForests();

        // THEN
        assertEquals(2, result.size());
        assertEquals(ForestType.TEMPERATE, result.get(0).type());
        assertEquals(ForestType.BOREAL, result.get(1).type());
    }

    @Test
    void shouldRemoveForest() {
        // GIVEN
        UUID forestId = UUID.randomUUID();

        // WHEN
        forestService.removeForest(forestId);

        // THEN
        verify(forestRepository, times(1)).delete(forestId);
    }
}
