package org.forest.web.controller;

import org.forest.api.controller.ForestApi;
import org.forest.api.model.ForestCreationRequest;
import org.forest.domain.model.Forest;
import org.forest.domain.model.ForestType;
import org.forest.domain.model.Tree;
import org.forest.port.driving.ForestUseCase;
import org.forest.port.driving.TreeUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping
public class ForestController implements ForestApi {
    private final Logger logger = LoggerFactory.getLogger(ForestController.class);
    private final ForestUseCase forestService;
    private final TreeUseCase treeService;

    @Autowired
    public ForestController(ForestUseCase forestService, TreeUseCase treeService) {
        this.forestService = forestService;
        this.treeService = treeService;
    }

    @Override
    public ResponseEntity<org.forest.api.model.Forest> createForest(ForestCreationRequest request) {
        List<Tree> trees = request.getTrees().stream()
                .map(treeReq -> treeService.get(UUID.fromString(treeReq.getId()))) // 🔥 Corregido UUID directo
                .filter(Optional::isPresent) // 🔥 Se usa lambda para evitar error de tipos
                .map(Optional::get)
                .collect(Collectors.toList());

        Forest newForest = new Forest(UUID.randomUUID(), 
                ForestType.valueOf(request.getType().getValue()), 
                trees, 
                request.getSurface());

        forestService.save(newForest);

        return ResponseEntity.ok(map(newForest));
    }

    @Override
    public ResponseEntity<Double> calculateForestAbsorption(String id) {
        return getOptionalUUID(id)
                .map(forestService::calculateCO2Absorption)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    @Override
    public ResponseEntity<Double> calculateSurfaceNeeded(Double co2AmountKg) {
        if (co2AmountKg == null || co2AmountKg <= 0) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(forestService.calculateSurfaceNeeded(co2AmountKg));
    }

    private Optional<UUID> getOptionalUUID(String uuid) {
        try {
            return Optional.of(UUID.fromString(uuid));
        } catch (IllegalArgumentException e) {
            logger.error("Error while parsing UUID", e);
            return Optional.empty();
        }
    }

    private org.forest.api.model.Forest map(Forest forest) {
        return new org.forest.api.model.Forest()
                .id(forest.id())
                .type(org.forest.api.model.ForestType.valueOf(forest.type().name()))
                .surface(forest.surface())
                .trees(forest.trees().stream().map(tree -> new org.forest.api.model.Tree()
                        .id(tree.id())
                        .birth(tree.birth())
                        .species(org.forest.api.model.Species.valueOf(tree.species().name()))
                        .exposure(org.forest.api.model.Exposure.valueOf(tree.exposure().name()))
                        .carbonStorageCapacity(tree.carbonStorageCapacity()))
                        .collect(Collectors.toList()));
    }
}
