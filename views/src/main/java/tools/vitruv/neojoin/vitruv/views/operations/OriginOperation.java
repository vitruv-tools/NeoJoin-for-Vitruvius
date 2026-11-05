package tools.vitruv.neojoin.vitruv.views.operations;

import org.eclipse.emf.ecore.EObject;

import tools.vitruv.change.atomic.EChange;
import tools.vitruv.neojoin.vitruv.views.GetContext;
import tools.vitruv.neojoin.vitruv.views.PutContext;
import tools.vitruv.neojoin.vitruv.views.bindings.OriginBinding;

import java.util.List;

/**
 * An origin operation. Origin operations are all operations that occur before view-side elements
 * exist.
 */
public interface OriginOperation {
    List<OriginBinding> doGet(GetContext context);

    OriginBinding doPut(EChange<EObject> viewChange, OriginBinding target, PutContext context);
}
