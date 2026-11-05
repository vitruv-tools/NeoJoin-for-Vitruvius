package tools.vitruv.neojoin.vitruv.generator.backend.description;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;

import java.util.List;
import java.util.Optional;

public record RootDescription(
        GenClass rootClass, Optional<ProjectDescription> rootProject, List<Contained> contained) {
    public record Contained(GenFeature feature, ProjectDescription project) {}
}
