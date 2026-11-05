@import tools.vitruv.neojoin.vitruv.generator.backend.description.JoinDescription
@import tools.vitruv.neojoin.vitruv.views.conditions.ConjunctiveCondition
@import tools.vitruv.neojoin.vitruv.views.conditions.FeatureCondition
@import tools.vitruv.neojoin.vitruv.views.operations.Join
@import tools.vitruv.dsls.common.JavaImportHelper

@param JoinDescription join
@param JavaImportHelper imports

!{imports.typeRef(Join.class);}
!{imports.typeRef(ConjunctiveCondition.class);}

new Join(
    ${join.sourceClass().getQualifiedClassifierAccessor()},
    this::${join.sourceObjectFactoryDeclaration().getMethodName()},
    @template.Origin(origin = join.origin(), imports = imports),
    Join.Type.${join.type().name()},
    new ConjunctiveCondition(
        !{boolean first = true;}
        @for(var featureCondition : join.featureConditions())
            @if(!first),@endif !{first = false;}
            !{imports.typeRef(FeatureCondition.class);}
            new FeatureCondition(
                ${featureCondition.leftIndex()},
                ${featureCondition.leftFeature().getQualifiedFeatureAccessor()},
                ${featureCondition.rightIndex()},
                ${featureCondition.rightFeature().getQualifiedFeatureAccessor()}
            )
        @endfor
        @for(var expressionCondition : join.expressionConditions())
            @if(!first),@endif !{first = false;}
            @template.Expression(expression = expressionCondition, imports = imports)
        @endfor
    )
)
