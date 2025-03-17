package org.forest.web.controller;

import org.forest.api.controller.TreeApi;
import org.forest.api.model.TreeUpdateRequest;
import org.forest.domain.model.Tree;
import org.forest.domain.model.Species;
import org.forest.domain.model.Exposure;
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
public class TreeController implements TreeApi {
    private final Logger logger = LoggerFactory.getLogger(TreeController.class);
    private final TreeUseCase treeService;

    @Autowired
    public TreeController(TreeUseCase treeUseCase) {
        this.treeService = treeUseCase;
    }

    @Override
    public ResponseEntity<List<org.forest.api.model.Tree>> listTrees() {
        return ResponseEntity.ok(treeService.list().stream().map(this::map).collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<org.forest.api.model.Tree> getTree(String id) {
        return getOptionalUUID(id)
                .flatMap(treeService::get)
                .map(this::map)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Void> updateTree(String id, TreeUpdateRequest apiTree) {
        return getOptionalUUID(id)
                .flatMap(treeService::get)
                .map(existingTree -> {
                    Tree updatedTree = new Tree(
                            existingTree.id(),
                            apiTree.getBirth() != null ? apiTree.getBirth() : existingTree.birth(),
                            apiTree.getSpecies() != null ? Species.valueOf(apiTree.getSpecies().getValue()) : existingTree.species(),
                            apiTree.getExposure() != null ? Exposure.valueOf(apiTree.getExposure().getValue()) : existingTree.exposure(),
                            apiTree.getCarbonStorageCapacity() != null ? apiTree.getCarbonStorageCapacity() : existingTree.carbonStorageCapacity()
                    );
                    treeService.save(updatedTree);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.badRequest().<Void>build()); // 🔥 Especificado <Void>
    }

    private Optional<UUID> getOptionalUUID(String uuid) {
        try {
            return Optional.of(UUID.fromString(uuid));
        } catch (IllegalArgumentException e) {
            logger.error("Error while parsing UUID", e);
            return Optional.empty();
        }
    }

    private Tree map(org.forest.api.model.Tree apiTree) {
        return new Tree(apiTree.getId(),
                apiTree.getBirth(),
                Species.valueOf(apiTree.getSpecies().getValue()),
                Exposure.valueOf(apiTree.getExposure().getValue()),
                apiTree.getCarbonStorageCapacity()
        );
    }

    private org.forest.api.model.Tree map(Tree modelTree) {
        return new org.forest.api.model.Tree()
                .id(modelTree.id())
                .birth(modelTree.birth())
                .species(org.forest.api.model.Species.valueOf(modelTree.species().name()))
                .exposure(org.forest.api.model.Exposure.valueOf(modelTree.exposure().name()))
                .carbonStorageCapacity(modelTree.carbonStorageCapacity());
    }
}
