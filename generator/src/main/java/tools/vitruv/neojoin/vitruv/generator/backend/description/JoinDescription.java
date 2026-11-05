package tools.vitruv.neojoin.vitruv.generator.backend.description;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;

import tools.vitruv.neojoin.vitruv.views.operations.Join;

import java.util.List;

public record JoinDescription(
        GenClass sourceClass,
        SourceObjectFactoryDeclarationDescription sourceObjectFactoryDeclaration,
        OriginDescription origin,
        Join.Type type,
        List<FeatureCondition> featureConditions,
        List<ExpressionDescription> expressionConditions)
        implements OriginDescription {
    public record FeatureCondition(
            int leftIndex, GenFeature leftFeature, int rightIndex, GenFeature rightFeature) {}
}
