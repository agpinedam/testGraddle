package org.forest.infrastructure.repository;

import org.forest.domain.model.Tree;
import org.forest.port.driven.TreeRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TreeRepositoryAdapter implements TreeRepositoryPort {
    private final List<Tree> mutableRepository = new ArrayList<>();

    @Override
    public List<Tree> findAll() {
        return mutableRepository;
    }

    @Override
    public Tree insert(Tree tree) {
        final Tree persisted = new Tree(UUID.randomUUID(), tree.birth(), tree.species(), tree.exposure(), tree.carbonStorageCapacity());
        mutableRepository.add(persisted);

        return persisted;
    }

    @Override
    public Optional<Tree> select(UUID id) {
        return mutableRepository.stream()
                .filter(tree -> tree.id().equals(id))
                .findFirst();
    }

    @Override
    public Tree update(Tree tree) {
        select(tree.id()).ifPresent(existingTree -> {
            mutableRepository.remove(existingTree);
            mutableRepository.add(tree);
        });
        return tree;
    }

    @Override
    public void remove(UUID id) {
        mutableRepository.removeIf(tree -> tree.id().equals(id));
    }
}
