package org.forest.port.driven;

import org.forest.domain.model.Tree;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TreeRepositoryPort {
    List<Tree> findAll();

    Tree insert(Tree tree);

    void remove(UUID uuid);

    Optional<Tree> select(UUID id);

    Tree update(Tree tree);

}
