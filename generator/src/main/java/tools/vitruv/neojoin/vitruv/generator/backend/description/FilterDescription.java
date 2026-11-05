package tools.vitruv.neojoin.vitruv.generator.backend.description;

public record FilterDescription(
    ExpressionDescription condition,
    OriginDescription origin
) implements OriginDescription {
}
