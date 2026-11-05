package tools.vitruv.neojoin.vitruv.generator.backend.description;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;

import java.util.List;

public record ExpressionDescription(String qualifiedMethodName, List<Parameter> parameters) {
    public record Parameter(GenClass parameterClass, int index) {}
}
