package tools.vitruv.neojoin.vitruv.generator.backend.description;

public record OnPutDeclarationDescription(
    String targetName
) implements DeclarationDescription {
  public String getMethodName() {
    return "onPut_" + targetName;
  }
}
