package hu.bme.aut.todolist.ui.main;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import javax.inject.Inject;
import javax.inject.Singleton;

import hu.bme.aut.todolist.TodoListApplication;
import hu.bme.aut.todolist.TodoListApplicationComponent;
import hu.bme.aut.todolist.interactor.tasks.GetTasksEvent;
import hu.bme.aut.todolist.interactor.tasks.TasksInteractor;
import hu.bme.aut.todolist.model.Task;
import hu.bme.aut.todolist.ui.Presenter;

@Singleton
public class MainPresenter extends Presenter<MainScreen> {
    TasksInteractor tasksInteractor;

    @Inject
    public MainPresenter(TasksInteractor tasksInteractor) {
        this.tasksInteractor = tasksInteractor;
        TodoListApplication.injector.inject(this);
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

    public void createTask(String name, String description) {
        Task task = new Task(name, description);
        tasksInteractor.createTask(task);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final GetTasksEvent event) {
        screen.showTasks(event.getTasks());
    }
}
