package tools.vitruv.neojoin.vitruv.views.internal.impl;

import java.util.Collection;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import tools.vitruv.framework.views.View;
import tools.vitruv.neojoin.vitruv.views.internal.OriginResourceAccess;

public class ViewWrappingOriginResourceAccessImpl extends AbstractOriginResourceAccess
    implements OriginResourceAccess {
  private final View view;

  public ViewWrappingOriginResourceAccessImpl(View view) {
    this.view = view;
  }

  public View getView() {
    return view;
  }

  public void update() {
    view.update();
    rebuildResourceMapping();
  }

  public boolean isOutdated() {
    return view.isOutdated();
  }

  @Override
  protected Collection<EObject> getRoots() {
    return view.getRootObjects();
  }

  @Override
  public void createResourceWithRoot(URI uriHint, EObject root) {
    view.registerRoot(root, determineOriginUri(root
                                                   .eClass()
                                                   .getEPackage(), uriHint));
    refreshResourceMapping();
  }

  @Override
  public void close() throws Exception {
    view.close();
  }
}
