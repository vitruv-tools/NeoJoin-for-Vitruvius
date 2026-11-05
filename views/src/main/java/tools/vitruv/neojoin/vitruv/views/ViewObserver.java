package tools.vitruv.neojoin.vitruv.views;

import org.eclipse.emf.ecore.EObject;

public interface ViewObserver {
  void originObjectCreated(EObject eObject);

  void originObjectDeleted(EObject eObject);
}
