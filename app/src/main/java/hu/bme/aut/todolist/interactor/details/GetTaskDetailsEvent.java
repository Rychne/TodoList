package hu.bme.aut.todolist.interactor.details;

import hu.bme.aut.todolist.model.Task;

public class GetTaskDetailsEvent {
    private int code;
    private Task TaskDetails;
    private Throwable throwable;

    public GetTaskDetailsEvent() {
    }

    public GetTaskDetailsEvent(int code, Task TaskDetails, Throwable throwable) {
        this.code = code;
        this.TaskDetails = TaskDetails;
        this.throwable = throwable;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Task getTaskDetails() {
        return TaskDetails;
    }

    public void setTaskDetails(Task TaskDetails) {
        this.TaskDetails = TaskDetails;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

}
