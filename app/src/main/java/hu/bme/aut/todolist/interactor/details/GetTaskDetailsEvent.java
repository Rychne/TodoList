package hu.bme.aut.todolist.interactor.details;

import hu.bme.aut.todolist.model.Item;

public class GetTaskDetailsEvent {
    private int code;
    private Item taskDetails;
    private Throwable throwable;

    public GetTaskDetailsEvent() {
    }

    public GetTaskDetailsEvent(int code, Item taskDetails, Throwable throwable) {
        this.code = code;
        this.taskDetails = taskDetails;
        this.throwable = throwable;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Item getTaskDetails() {
        return taskDetails;
    }

    public void setTaskDetails(Item taskDetails) {
        this.taskDetails = taskDetails;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

}
