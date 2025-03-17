package org.forest.infrastructure.repository;

import org.forest.domain.model.Forest;
import org.forest.port.driven.ForestRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ForestRepositoryAdapter implements ForestRepositoryPort {
    private final List<Forest> mutableRepository = new ArrayList<>();

    @Override
    public List<Forest> selectAll() {
        return new ArrayList<>(mutableRepository);
    }

    @Override
    public Optional<Forest> select(UUID id) {
        return mutableRepository.stream()
                .filter(forest -> forest.id().equals(id))
                .findFirst();
    }

    @Override
    public Forest insert(Forest forest) {
        final Forest persisted = new Forest(UUID.randomUUID(), forest.type(), forest.trees(), forest.surface());
        mutableRepository.add(persisted);
        return persisted;
    }

    @Override
    public Forest update(Forest forest) {
        select(forest.id()).ifPresent(existingForest -> {
            mutableRepository.remove(existingForest);
            mutableRepository.add(forest);
        });
        return forest;
    }

    @Override
    public void delete(UUID id) {
        mutableRepository.removeIf(forest -> forest.id().equals(id));
    }
}
