package org.forest.domain.service;

import org.forest.domain.model.Forest;
import org.forest.domain.model.Tree;
import org.forest.port.driven.ForestRepositoryPort;
import org.forest.port.driven.TreeRepositoryPort;
import org.forest.port.driving.ForestUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ForestService implements ForestUseCase {

    private final ForestRepositoryPort forestRepositoryPort;
    private final TreeRepositoryPort treeRepositoryPort;

    @Autowired
    public ForestService(ForestRepositoryPort forestRepositoryPort, TreeRepositoryPort treeRepositoryPort) {
        this.forestRepositoryPort = forestRepositoryPort;
        this.treeRepositoryPort = treeRepositoryPort;
    }

    @Override
    @Transactional
    public Forest createForest(Forest forest) {
        validateForest(forest);
        return forestRepositoryPort.insert(forest);
    }

    private void validateForest(Forest forest) {
        if (forest.trees() == null || forest.trees().isEmpty()) {
            throw new IllegalArgumentException("Forest must contain at least one tree.");
        }

        for (Tree tree : forest.trees()) {
            if (tree.id() == null || treeRepositoryPort.select(tree.id()).isEmpty()) {
                throw new IllegalArgumentException("Tree with ID " + tree.id() + " does not exist.");
            }
        }

        if (forest.surface() <= 0) {
            throw new IllegalArgumentException("Forest surface must be positive.");
        }

        if (forest.type() == null) {
            throw new IllegalArgumentException("Forest type is required.");
        }
    }

    @Override
    public Optional<Forest> getForest(UUID id) {
        return forestRepositoryPort.select(id);
    }

    @Override
    public List<Forest> listForests() {
        return forestRepositoryPort.selectAll();
    }

    @Override
    @Transactional
    public void removeForest(UUID id) {
        forestRepositoryPort.delete(id);
    }
}
