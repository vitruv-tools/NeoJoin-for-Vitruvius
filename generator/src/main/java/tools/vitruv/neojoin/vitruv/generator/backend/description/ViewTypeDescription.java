package tools.vitruv.neojoin.vitruv.generator.backend.description;

import tools.vitruv.neojoin.vitruv.generator.tools.Metamodel;

import java.util.List;

public record ViewTypeDescription(
        String className,
        String name,
        List<Metamodel> originMetamodels,
        Metamodel viewtypeMetamodel,
        RootDescription root,
        List<DeclarationDescription> declarations) {}
