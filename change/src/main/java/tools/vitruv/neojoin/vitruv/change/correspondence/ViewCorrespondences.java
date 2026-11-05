package tools.vitruv.neojoin.vitruv.change.correspondence;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import java.util.List;

public interface ViewCorrespondences {
    boolean canProvideViewObjectForOriginObjects(List<EObject> originObjects, EClass viewClass);

    EObject getCorrespondingViewObjectForOriginObjects(
            List<EObject> originObjects, EClass viewClass);

    boolean canProvideOriginObjectsForViewObject(EObject viewObject);

    List<EObject> getCorrespondingOriginObjectsForViewObject(EObject viewObject);
}
