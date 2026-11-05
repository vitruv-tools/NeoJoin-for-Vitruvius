package tools.vitruv.neojoin.vitruv.generator.backend.description;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;

import java.util.List;

public record ProjectDescription(
        GenClass targetClass,
        OriginDescription origin,
        List<FeatureProjectDescription> features,
        OnPutDeclarationDescription onPutDeclaration) {}
