package tools.vitruv.neojoin.vitruv.generator.backend.description;

import java.util.List;
import tools.vitruv.neojoin.vitruv.generator.tools.Metamodel;

public record ViewTypeDescription(
    String className,
    String name,
    List<Metamodel> originMetamodels,
    Metamodel viewtypeMetamodel,
    RootDescription root,
    List<DeclarationDescription> declarations
) {
}
