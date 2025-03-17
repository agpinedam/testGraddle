package org.forest.infrastructure.repository;

import org.forest.domain.model.Tree;
import org.forest.domain.model.Species;
import org.forest.domain.model.Exposure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class TreeRepositoryAdapterTest {

    private TreeRepositoryAdapter treeRepository;

    @BeforeEach
    void setUp() {
        treeRepository = new TreeRepositoryAdapter();
    }

    @Test
    void shouldInsertTree() {
        // GIVEN
        Tree tree = new Tree(null, LocalDate.now(), Species.OAK, Exposure.SUNNY, 30);

        // WHEN
        Tree persistedTree = treeRepository.insert(tree);

        // THEN
        assertNotNull(persistedTree.id());
        assertEquals(tree.species(), persistedTree.species());
        assertEquals(tree.exposure(), persistedTree.exposure());
        assertEquals(tree.carbonStorageCapacity(), persistedTree.carbonStorageCapacity());
    }

    @Test
    void shouldFindAllTrees() {
        // GIVEN
        Tree tree1 = treeRepository.insert(new Tree(null, LocalDate.now(), Species.OAK, Exposure.SUNNY, 30));
        Tree tree2 = treeRepository.insert(new Tree(null, LocalDate.now(), Species.BEECH, Exposure.SHADOW, 40));

        // WHEN
        List<Tree> trees = treeRepository.findAll();

        // THEN
        assertEquals(2, trees.size());
        assertTrue(trees.contains(tree1));
        assertTrue(trees.contains(tree2));
    }

    @Test
    void shouldSelectTreeById() {
        // GIVEN
        Tree tree = treeRepository.insert(new Tree(null, LocalDate.now(), Species.FIR, Exposure.MID_SHADOW, 35));

        // WHEN
        Optional<Tree> foundTree = treeRepository.select(tree.id());

        // THEN
        assertTrue(foundTree.isPresent());
        assertEquals(tree.id(), foundTree.get().id());
    }

    @Test
    void shouldReturnEmptyWhenTreeNotFound() {
        // GIVEN
        UUID randomId = UUID.randomUUID();

        // WHEN
        Optional<Tree> foundTree = treeRepository.select(randomId);

        // THEN
        assertTrue(foundTree.isEmpty());
    }

    @Test
    void shouldUpdateTree() {
        // GIVEN
        Tree tree = treeRepository.insert(new Tree(null, LocalDate.now(), Species.OAK, Exposure.SUNNY, 30));
        Tree updatedTree = new Tree(tree.id(), LocalDate.now(), Species.ASH, Exposure.SHADOW, 45);

        // WHEN
        treeRepository.update(updatedTree);
        Optional<Tree> foundTree = treeRepository.select(tree.id());

        // THEN
        assertTrue(foundTree.isPresent());
        assertEquals(Species.ASH, foundTree.get().species());
        assertEquals(45, foundTree.get().carbonStorageCapacity());
    }

    @Test
    void shouldDeleteTree() {
        // GIVEN
        Tree tree = treeRepository.insert(new Tree(null, LocalDate.now(), Species.BEECH, Exposure.SHADOW, 40));

        // WHEN
        treeRepository.delete(tree.id());

        // THEN
        assertTrue(treeRepository.select(tree.id()).isEmpty());
    }
}
