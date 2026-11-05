package tools.vitruv.neojoin.vitruv.views;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;

/**
 * Used to track correspondences between objects in the origin models and the objects of the view.
 * There are two reasons why this interface is used instead of the correspondence model:
 *
 * <ol>
 *   <li>The correspondence model is not directional, this interface is.
 *   <li>The correspondence model supports serialization, this explicitly does not; views are
 *       temporary.
 * </ol>
 */
public interface ViewCorrespondences {
    EObject getCorrespondingViewObjectForOriginObjects(
            List<EObject> originObjects, EClass viewClass);

    List<EObject> getCorrespondingOriginObjectsForViewObject(EObject viewObject);

    Set<EObject> getCorrespondingViewObjectForPartialOriginObjects(
            EObject originObject, EClass viewClass);

    boolean correspond(List<EObject> originObjects, EObject viewObject);

    void forEach(BiConsumer<List<EObject>, EObject> action);
}
