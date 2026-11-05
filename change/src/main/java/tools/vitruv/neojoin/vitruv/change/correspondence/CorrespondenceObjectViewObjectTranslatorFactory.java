package tools.vitruv.neojoin.vitruv.change.correspondence;

import tools.vitruv.framework.views.ViewType;
import tools.vitruv.neojoin.vitruv.views.internal.ViewResourceAccess;

public interface CorrespondenceObjectViewObjectTranslatorFactory {
  CorrespondenceObjectViewObjectTranslator createCorrespondenceResolver(ViewType<?> viewType,
                                                                        ViewResourceAccess viewResourceAccess);
}
