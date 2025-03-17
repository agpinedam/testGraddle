package org.forest.port.driven;

import org.forest.domain.model.Forest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ForestRepositoryPort {

    Forest insert(Forest forest);

    Optional<Forest> select(UUID id);

    List<Forest> selectAll();

    Forest update(Forest forest);

    void delete(UUID id);
}
