package org.forest.port.driving;

import org.forest.domain.model.Tree;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TreeUseCase {
    Optional<Tree> get(UUID uuid);

    List<Tree> list();

    Tree save(Tree tree);

    void remove(UUID uuid);

    Tree update(UUID id, Tree tree);
}
