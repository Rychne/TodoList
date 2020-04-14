package hu.bme.aut.todolist.ui.main;

import hu.bme.aut.todolist.interactor.tasks.TasksInteractor;
import hu.bme.aut.todolist.ui.Presenter;

public class MainPresenter extends Presenter<MainScreen> {
    TasksInteractor tasksInteractor;

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
}
