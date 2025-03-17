package org.forest.domain.service;

import org.forest.domain.model.Forest;
import org.forest.domain.model.Tree;
import org.forest.port.driving.CO2AbsorptionUseCase;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CO2AbsorptionService implements CO2AbsorptionUseCase {

    @Override
    public double getAbsorption(Forest forest) {
        if (forest == null || forest.trees() == null || forest.trees().isEmpty()) {
            throw new IllegalArgumentException("Forest and its trees must not be null or empty");
        }

        double totalAbsorption = forest.trees()
                .stream()
                .mapToDouble(Tree::carbonStorageCapacity)
                .sum();

        double diversityFactor = calculateDiversityFactor(forest);

        return totalAbsorptionWithDiversity(totalAbsorption, diversityFactor, forest.surface());
    }

    private double calculateDiversityFactor(Forest forest) {
        long uniqueSpeciesCount = forest.trees().stream()
                .map(Tree::species)
                .collect(Collectors.toSet())
                .size();
        return 1 + (uniqueSpeciesCount * 0.05);
    }

    private double totalAbsorptionWithDiversity(double totalAbsorption, double diversityFactor, double surface) {
        return totalAbsorption * diversityFactor * surface;
    }
}
