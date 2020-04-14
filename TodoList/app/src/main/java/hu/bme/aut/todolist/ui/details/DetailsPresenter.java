package hu.bme.aut.todolist.ui.details;

import hu.bme.aut.todolist.interactor.details.DetailsInteractor;
import hu.bme.aut.todolist.ui.Presenter;

public class DetailsPresenter extends Presenter<DetailsScreen> {

    DetailsInteractor detailsInteractor;

    @Override
    public void attachScreen(DetailsScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void refreshTaskDetails(final String taskDetailsQuery) {
        detailsInteractor.getTaskDetails(taskDetailsQuery);
    }
}
