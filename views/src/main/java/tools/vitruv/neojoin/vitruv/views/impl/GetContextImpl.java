package tools.vitruv.neojoin.vitruv.views.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import tools.vitruv.neojoin.vitruv.views.EditableViewCorrespondences;
import tools.vitruv.neojoin.vitruv.views.internal.OriginResourceAccess;
import tools.vitruv.neojoin.vitruv.views.internal.ViewResourceAccess;

public final class GetContextImpl extends AbstractGetContext {
  private final Map<EClass, List<EObject>> originObjectsByClass = new HashMap<>();

  public GetContextImpl(OriginResourceAccess originResourceAccess,
                        ViewResourceAccess viewResourceAccess,
                        EditableViewCorrespondences correspondences) {
    super(originResourceAccess, viewResourceAccess, correspondences);
  }

  @Override
  public List<EObject> getOriginObjects(EClass eClass) {
    return originObjectsByClass.computeIfAbsent(eClass, super::getOriginObjects);
  }
}
