@import tools.vitruv.neojoin.vitruv.generator.backend.description.FilterDescription
@import tools.vitruv.neojoin.vitruv.generator.backend.description.JoinDescription
@import tools.vitruv.neojoin.vitruv.generator.backend.description.OriginDescription
@import tools.vitruv.neojoin.vitruv.generator.backend.description.SourceDescription
@import tools.vitruv.dsls.common.JavaImportHelper

@param OriginDescription origin 
@param JavaImportHelper imports

@if(origin instanceof FilterDescription filter)
    @template.Filter(filter = filter, imports = imports)
@elseif(origin instanceof JoinDescription join)
    @template.Join(join = join, imports = imports)
@elseif(origin instanceof SourceDescription source)
    @template.Source(source = source, imports = imports)
@endif
