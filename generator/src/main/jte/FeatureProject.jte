@import java.util.Optional
@import tools.vitruv.neojoin.vitruv.generator.backend.description.FeatureProjectDescription
@import tools.vitruv.neojoin.vitruv.views.operations.FeatureProject
@import tools.vitruv.dsls.common.JavaImportHelper

@param FeatureProjectDescription featureProject
@param JavaImportHelper imports
 
!{imports.typeRef(FeatureProject.class);} 
!{imports.typeRef(Optional.class);}

new FeatureProject(
    @if(featureProject.targetIndex().isPresent())
        Optional.of(${featureProject.targetIndex().get()}),
    @else
        Optional.empty(),
    @endif
    ${featureProject.createdFeature().getQualifiedFeatureAccessor()},
    @template.FeatureOrigin(featureOrigin = featureProject.origin(), imports = imports)
)
