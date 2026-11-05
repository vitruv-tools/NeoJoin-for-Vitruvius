package tools.vitruv.neojoin.vitruv.views.conditions;

import tools.vitruv.neojoin.vitruv.views.bindings.OriginBinding;

@FunctionalInterface
public interface Condition {
    Condition TRUE = originBinding -> true;

    boolean evaluate(OriginBinding originBinding);
}
