package tools.vitruv.neojoin.vitruv.change.correspondence;

import tools.vitruv.change.correspondence.Correspondence;
import tools.vitruv.change.correspondence.view.EditableCorrespondenceModelView;

public interface TranslatedCorrespondenceModelView extends AutoCloseable {
  EditableCorrespondenceModelView<Correspondence> getCorrespondenceModelView();

  @Override
  void close();
}
