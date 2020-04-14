package hu.bme.aut.todolist.interactor.tasks;

import javax.inject.Inject;

import hu.bme.aut.todolist.TodoListApplication;

public class TasksInteractor {

    @Inject
    public TasksInteractor() {
        TodoListApplication.injector.inject(this);
    }

    public void getTasks() {

    }
}
