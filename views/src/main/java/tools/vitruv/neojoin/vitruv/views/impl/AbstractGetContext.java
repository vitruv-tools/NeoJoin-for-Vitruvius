package tools.vitruv.neojoin.vitruv.views.impl;

import org.eclipse.emf.ecore.EObject;
import tools.vitruv.neojoin.vitruv.views.EditableViewCorrespondences;
import tools.vitruv.neojoin.vitruv.views.GetContext;
import tools.vitruv.neojoin.vitruv.views.internal.OriginResourceAccess;
import tools.vitruv.neojoin.vitruv.views.internal.ViewResourceAccess;

public abstract class AbstractGetContext extends AbstractContext implements GetContext {
  private final ViewResourceAccess viewResourceAccess;

  protected AbstractGetContext(
      OriginResourceAccess originResourceAccess,
      ViewResourceAccess viewResourceAccess,
      EditableViewCorrespondences correspondences) {
    super(originResourceAccess, correspondences);
    this.viewResourceAccess = viewResourceAccess;
  }

  @Override
  public void insertViewRoot(EObject root) {
    viewResourceAccess.insertRoot(root);
  }
}
