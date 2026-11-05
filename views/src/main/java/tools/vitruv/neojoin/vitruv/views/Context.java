package tools.vitruv.neojoin.vitruv.views;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import java.util.List;

public interface Context {
    List<EObject> getOriginObjects(EClass eClass);

    EditableViewCorrespondences getCorrespondences();
}
