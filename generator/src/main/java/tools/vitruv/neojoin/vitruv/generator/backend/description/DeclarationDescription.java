package tools.vitruv.neojoin.vitruv.generator.backend.description;

public sealed interface DeclarationDescription
        permits SourceObjectFactoryDeclarationDescription,
                TransformDeclarationDescription,
                OnPutDeclarationDescription {}
