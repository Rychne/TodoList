package hu.bme.aut.todolist.ui.details;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import hu.bme.aut.todolist.TodoListApplication;
import hu.bme.aut.todolist.interactor.details.DetailsInteractor;
import hu.bme.aut.todolist.interactor.details.GetTaskDetailsEvent;
import hu.bme.aut.todolist.network.Execute;
import hu.bme.aut.todolist.ui.Presenter;

public class DetailsPresenter extends Presenter<DetailsScreen> {
    public static final String TAG = DetailsPresenter.class.getSimpleName();

    DetailsInteractor detailsInteractor;
    Executor executor;

    @Inject
    public DetailsPresenter(DetailsInteractor detailsInteractor, @Execute Executor executor) {
        this.detailsInteractor = detailsInteractor;
        this.executor = executor;
        TodoListApplication.injector.inject(this);
    }

    @Override
    public void attachScreen(DetailsScreen screen) {
        super.attachScreen(screen);
        EventBus.getDefault().register(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
        EventBus.getDefault().unregister(this);
    }

    public void refreshTaskDetails(final String taskDetailsQuery) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                detailsInteractor.getTaskDetails(taskDetailsQuery);
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final GetTaskDetailsEvent event) {
        screen.showTask(event.getTaskDetails());
    }
}
