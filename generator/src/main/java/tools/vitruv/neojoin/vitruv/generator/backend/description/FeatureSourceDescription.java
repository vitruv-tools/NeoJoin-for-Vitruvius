package tools.vitruv.neojoin.vitruv.generator.backend.description;

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;

import java.util.List;

public record FeatureSourceDescription(int targetIndex, List<GenFeature> targetFeatures)
        implements FeatureOriginDescription {}
