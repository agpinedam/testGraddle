package org.forest.domain.service;

import org.forest.domain.model.Tree;
import org.forest.port.driven.TreeRepositoryPort;
import org.forest.port.driving.TreeUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class TreeService implements TreeUseCase {
    private TreeRepositoryPort treeRepository;

    @Autowired
    public TreeService(TreeRepositoryPort treeRepository) {
        this.treeRepository = treeRepository;
    }

    @Override
    public Optional<Tree> get(UUID uuid) {
        return treeRepository.findAll().stream()
                .filter(tree -> uuid.equals(tree.id()))
                .findFirst();
    }


    @Override
    public List<Tree> list() {
        return treeRepository.findAll();
    }

    @Override
    public Tree save(Tree tree) {
        if (tree.birth() == null) {
            throw new IllegalArgumentException("Birth date is required");
        }
        if (tree.carbonStorageCapacity() < 10 || tree.carbonStorageCapacity() > 50) {
            throw new IllegalArgumentException("Carbon storage capacity must be between 10 and 50 kg/year");
        }
        return treeRepository.insert(tree);
    }

    @Override
    public void remove(UUID uuid) {
        treeRepository.remove(uuid);
    }

    @Override
    public Tree update(UUID id, Tree tree) {
        if (treeRepository.select(id).isEmpty()) {
            throw new IllegalArgumentException("Tree with ID " + id + " does not exist.");
        }

        return treeRepository.update(tree);
    }
}
