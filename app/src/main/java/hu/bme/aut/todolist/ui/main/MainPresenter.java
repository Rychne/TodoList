package hu.bme.aut.todolist.ui.main;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import javax.inject.Inject;

import hu.bme.aut.todolist.interactor.tasks.GetTasksEvent;
import hu.bme.aut.todolist.interactor.tasks.TasksInteractor;
import hu.bme.aut.todolist.ui.Presenter;

public class MainPresenter extends Presenter<MainScreen> {
    TasksInteractor tasksInteractor;

    @Inject
    public MainPresenter(TasksInteractor tasksInteractor) {
        this.tasksInteractor = tasksInteractor;
    }

    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void refreshTasks() {
        tasksInteractor.getTasks();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final GetTasksEvent event) {
        screen.showTasks(event.getTasks());
    }
}
