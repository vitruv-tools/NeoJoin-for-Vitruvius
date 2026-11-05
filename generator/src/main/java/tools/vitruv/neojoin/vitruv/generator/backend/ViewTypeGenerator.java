package tools.vitruv.neojoin.vitruv.generator.backend;

import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.output.StringOutput;

import tools.vitruv.dsls.common.JavaImportHelper;
import tools.vitruv.neojoin.vitruv.generator.backend.description.ViewTypeDescription;

import java.util.Map;

public final class ViewTypeGenerator {
    public static final ViewTypeGenerator INSTANCE = new ViewTypeGenerator();
    private static final TemplateEngine ENGINE =
            TemplateEngine.createPrecompiled(ContentType.Plain);

    private ViewTypeGenerator() {}

    public String generate(ViewTypeDescription description, JavaImportHelper imports) {
        StringOutput output = new StringOutput();
        ENGINE.render("ViewType", Map.of("viewType", description, "imports", imports), output);
        return output.toString();
    }
}
