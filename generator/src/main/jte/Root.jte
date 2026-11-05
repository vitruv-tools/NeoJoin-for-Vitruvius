@import gg.jte.support.ForSupport
@import java.util.List
@import java.util.Optional
@import tools.vitruv.neojoin.vitruv.generator.backend.description.RootDescription
@import tools.vitruv.neojoin.vitruv.views.operations.Root
@import tools.vitruv.dsls.common.JavaImportHelper

@param RootDescription root
@param JavaImportHelper imports
 
!{imports.typeRef(Root.class);} 
!{imports.typeRef(Optional.class);} 
!{imports.typeRef(List.class);} 

new Root(
    ${root.rootClass().getQualifiedClassifierAccessor()},
    @if(root.rootProject().isPresent())
        Optional.of(@template.Project(project = root.rootProject().get(), imports = imports)),
    @else
        Optional.empty(),
    @endif
    List.of(
        @for(var contained : ForSupport.of(root.contained()))
            new Root.Target(
                ${contained.get().feature().getQualifiedFeatureAccessor()},
                @template.Project(project = contained.get().project(), imports = imports)
            )
            @if(!contained.isLast()), @endif
        @endfor
    )
)
