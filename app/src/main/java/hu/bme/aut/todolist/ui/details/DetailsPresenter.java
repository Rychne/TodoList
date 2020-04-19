package hu.bme.aut.todolist.ui.details;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import javax.inject.Inject;

import hu.bme.aut.todolist.interactor.details.DetailsInteractor;
import hu.bme.aut.todolist.interactor.details.GetTaskDetailsEvent;
import hu.bme.aut.todolist.ui.Presenter;

public class DetailsPresenter extends Presenter<DetailsScreen> {

    DetailsInteractor detailsInteractor;

    @Inject
    public DetailsPresenter(DetailsInteractor detailsInteractor) {
        this.detailsInteractor = detailsInteractor;
    }

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

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final GetTaskDetailsEvent event) {
        screen.showTask(event.getTaskDetails());
    }
}
