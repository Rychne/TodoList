package hu.bme.aut.todolist.interactor.tasks.events;

import hu.bme.aut.todolist.model.Task;

public class CreateTaskEvent {
    private int code;
    private Task task;
    private Throwable throwable;

    public CreateTaskEvent() {}

    public CreateTaskEvent(int code, Task task, Throwable throwable) {
        this.code = code;
        this.task = task;
        this.throwable = throwable;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
