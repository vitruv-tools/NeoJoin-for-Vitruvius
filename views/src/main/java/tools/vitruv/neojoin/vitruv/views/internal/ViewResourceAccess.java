package tools.vitruv.neojoin.vitruv.views.internal;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;

import tools.vitruv.change.utils.ResourceAccess;

import java.util.Collection;

public interface ViewResourceAccess extends ResourceAccess, AutoCloseable {
    void reset();

    ResourceSet getResourceSet();

    void insertRoot(EObject root);

    void registerRoot(EObject root, URI uri);

    void moveRoot(EObject root, URI uri);

    Collection<EObject> getRoots();
}
