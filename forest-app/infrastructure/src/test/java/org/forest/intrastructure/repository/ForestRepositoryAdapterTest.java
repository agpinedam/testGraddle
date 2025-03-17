package org.forest.infrastructure.repository;

import org.forest.domain.model.Forest;
import org.forest.domain.model.ForestType;
import org.forest.domain.model.Tree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ForestRepositoryAdapterTest {

    private ForestRepositoryAdapter forestRepository;

    @BeforeEach
    void setUp() {
        forestRepository = new ForestRepositoryAdapter();
    }

    @Test
    void shouldInsertForest() {
        // GIVEN
        Forest forest = new Forest(null, ForestType.TEMPERATE, List.of(), 100);

        // WHEN
        Forest persistedForest = forestRepository.insert(forest);

        // THEN
        assertNotNull(persistedForest.id());
        assertEquals(forest.type(), persistedForest.type());
        assertEquals(forest.surface(), persistedForest.surface());
        assertEquals(0, persistedForest.trees().size()); // Sin árboles en este caso
    }

    @Test
    void shouldFindAllForests() {
        // GIVEN
        Forest forest1 = forestRepository.insert(new Forest(null, ForestType.BOREAL, List.of(), 150));
        Forest forest2 = forestRepository.insert(new Forest(null, ForestType.TROPICAL, List.of(), 200));

        // WHEN
        List<Forest> forests = forestRepository.selectAll();

        // THEN
        assertEquals(2, forests.size());
        assertTrue(forests.contains(forest1));
        assertTrue(forests.contains(forest2));
    }

    @Test
    void shouldSelectForestById() {
        // GIVEN
        Forest forest = forestRepository.insert(new Forest(null, ForestType.TEMPERATE, List.of(), 180));

        // WHEN
        Optional<Forest> foundForest = forestRepository.select(forest.id());

        // THEN
        assertTrue(foundForest.isPresent());
        assertEquals(forest.id(), foundForest.get().id());
    }

    @Test
    void shouldReturnEmptyWhenForestNotFound() {
        // GIVEN
        UUID randomId = UUID.randomUUID();

        // WHEN
        Optional<Forest> foundForest = forestRepository.select(randomId);

        // THEN
        assertTrue(foundForest.isEmpty());
    }

    @Test
    void shouldUpdateForest() {
        // GIVEN
        Forest forest = forestRepository.insert(new Forest(null, ForestType.TEMPERATE, List.of(), 120));
        Forest updatedForest = new Forest(forest.id(), ForestType.BOREAL, List.of(new Tree(UUID.randomUUID(), null, null, null, 30)), 160);

        // WHEN
        forestRepository.update(updatedForest);
        Optional<Forest> foundForest = forestRepository.select(forest.id());

        // THEN
        assertTrue(foundForest.isPresent());
        assertEquals(ForestType.BOREAL, foundForest.get().type());
        assertEquals(160, foundForest.get().surface());
        assertEquals(1, foundForest.get().trees().size()); // Ahora tiene un árbol
    }

    @Test
    void shouldDeleteForest() {
        // GIVEN
        Forest forest = forestRepository.insert(new Forest(null, ForestType.TROPICAL, List.of(), 200));

        // WHEN
        forestRepository.delete(forest.id());

        // THEN
        assertTrue(forestRepository.select(forest.id()).isEmpty());
    }
}
