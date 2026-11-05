package tools.vitruv.neojoin.vitruv.views.operations;

import org.eclipse.emf.ecore.EObject;
import tools.vitruv.change.atomic.EChange;
import tools.vitruv.neojoin.vitruv.views.GetContext;
import tools.vitruv.neojoin.vitruv.views.PutContext;
import tools.vitruv.neojoin.vitruv.views.bindings.FeatureOriginBinding;
import tools.vitruv.neojoin.vitruv.views.bindings.ObjectBinding;
import tools.vitruv.neojoin.vitruv.views.bindings.ValueUpdateBinding;

/**
 * An origin operation providing a feature.
 * Origin operations are all operations that occur before view-side elements exist.
 */
public interface FeatureOriginOperation {
  FeatureOriginBinding doGet(ObjectBinding subjectBinding, GetContext context);

  FeatureOriginBinding doPut(EChange<EObject> viewChange, FeatureOriginBinding feature,
                             ObjectBinding subjectBinding, ValueUpdateBinding value,
                             PutContext context);
}
