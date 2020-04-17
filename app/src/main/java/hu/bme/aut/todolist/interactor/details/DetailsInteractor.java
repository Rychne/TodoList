package hu.bme.aut.todolist.interactor.details;

import javax.inject.Inject;

import hu.bme.aut.todolist.TodoListApplication;

public class DetailsInteractor {

    @Inject
    public DetailsInteractor() {
        TodoListApplication.injector.inject(this);
    }

    public void getTaskDetails(String taskDetailsQuery) {

    }
}
