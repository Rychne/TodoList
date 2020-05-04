package hu.bme.aut.todolist.ui.main;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.concurrent.Executor;

import javax.inject.Inject;
import javax.inject.Singleton;

import hu.bme.aut.todolist.TodoListApplication;
import hu.bme.aut.todolist.TodoListApplicationComponent;
import hu.bme.aut.todolist.interactor.tasks.GetTasksEvent;
import hu.bme.aut.todolist.interactor.tasks.TasksInteractor;
import hu.bme.aut.todolist.model.Task;
import hu.bme.aut.todolist.network.Execute;
import hu.bme.aut.todolist.ui.Presenter;

@Singleton
public class MainPresenter extends Presenter<MainScreen> {
    TasksInteractor tasksInteractor;
    Executor executor;

    @Inject
    public MainPresenter(TasksInteractor tasksInteractor, @Execute Executor executor) {
        this.tasksInteractor = tasksInteractor;
        this.executor = executor;
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
        executor.execute(new Runnable() {
            @Override
            public void run() {
                tasksInteractor.getTasks();
            }
        });
    }

    public void createTask(final Task task) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                tasksInteractor.createTask(task);
            }
        });
    }

    public void updateTask(final Task task) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                tasksInteractor.updateTask(task);
            }
        });
    }

    public void deleteTask(final Task task) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                tasksInteractor.delete(task);
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final GetTasksEvent event) {
        screen.showTasks(event.getTasks());
    }
}
