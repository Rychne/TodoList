package hu.bme.aut.todolist.interactor.tasks.events;

import java.util.List;

import hu.bme.aut.todolist.model.Task;

public class GetTasksEvent {

    private int code;
    private List<Task> tasks;
    private Throwable throwable;

    public GetTasksEvent(){
    }

    public GetTasksEvent(int code, List<Task> tasks, Throwable throwable) {
        this.code = code;
        this.tasks = tasks;
        this.throwable = throwable;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
