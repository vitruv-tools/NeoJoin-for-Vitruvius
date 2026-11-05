package tools.vitruv.neojoin.vitruv.generator.backend.description;

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;

import java.util.Optional;

public record FeatureProjectDescription(
        Optional<Integer> targetIndex,
        GenFeature createdFeature,
        FeatureOriginDescription origin) {}
