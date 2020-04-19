package hu.bme.aut.todolist.interactor.details;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import hu.bme.aut.todolist.TodoListApplication;

public class DetailsInteractor {

    @Inject
    public DetailsInteractor() {
        TodoListApplication.injector.inject(this);
    }

    public void getTaskDetails(String taskDetailsQuery) {
        GetTaskDetailsEvent event = new GetTaskDetailsEvent();

        EventBus.getDefault().post(event);
    }
}
