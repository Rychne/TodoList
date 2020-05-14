package hu.bme.aut.todolist.ui.main;

import android.util.Log;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.concurrent.Executor;

import javax.inject.Inject;
import javax.inject.Singleton;

import hu.bme.aut.todolist.TodoListApplication;
import hu.bme.aut.todolist.interactor.tasks.events.CreateTaskEvent;
import hu.bme.aut.todolist.interactor.tasks.events.DeleteTaskEvent;
import hu.bme.aut.todolist.interactor.tasks.events.GetTasksEvent;
import hu.bme.aut.todolist.interactor.tasks.TasksInteractor;
import hu.bme.aut.todolist.interactor.tasks.events.UpdateTaskEvent;
import hu.bme.aut.todolist.model.Task;
import hu.bme.aut.todolist.network.Execute;
import hu.bme.aut.todolist.ui.Presenter;

@Singleton
public class MainPresenter extends Presenter<MainScreen> {
    public static final String TAG = MainPresenter.class.getSimpleName();
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
        EventBus.getDefault().register(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
        EventBus.getDefault().unregister(this);
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
        Log.d(TAG, "createTask: " + task.getName());
        executor.execute(new Runnable() {
            @Override
            public void run() {
                tasksInteractor.createTask(task);
            }
        });
    }

    public void updateTask(final Task task) {
        Log.d(TAG, "updateTask: " + task.getId());
        executor.execute(new Runnable() {
            @Override
            public void run() {
                tasksInteractor.updateTask(task);
            }
        });
    }

    public void deleteTask(final Task task) {
        Log.d(TAG, "deleteTask: " + task.getId());
        executor.execute(new Runnable() {
            @Override
            public void run() {
                tasksInteractor.delete(task);
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final GetTasksEvent event) {
        Log.d(TAG, "onEventMainThread - GetTasksEvent");
        screen.showTasks(event.getTasks());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final CreateTaskEvent event) {
        Log.d(TAG, "onEventMainThread - CreateTaskEvent - Task: " + event.getTask().getId());
        screen.addTask(event.getTask());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final UpdateTaskEvent event) {
        Log.d(TAG, "onEventMainThread - UpdateTaskEvent");
        screen.updateTask(event.getTask());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onDeleteTaskEventMainThread(final DeleteTaskEvent event) {
        Log.d(TAG, "onEventMainThread - DeleteTaskEvent");
        screen.removeTask(event.getTaskId());
    }
}
