package org.forest.port.driving;

import org.forest.domain.model.Forest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ForestUseCase {

    Forest createForest(Forest forest);

    Optional<Forest> getForest(UUID id);

    List<Forest> listForests();

    void removeForest(UUID id);
}
