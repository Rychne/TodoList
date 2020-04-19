package hu.bme.aut.todolist.interactor.tasks;

import java.util.List;

import hu.bme.aut.todolist.model.Item;

public class GetTasksEvent {

    private int code;
    private List<Item> tasks;
    private Throwable throwable;

    public GetTasksEvent(){
    }

    public GetTasksEvent(int code, List<Item> tasks, Throwable throwable) {
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

    public List<Item> getTasks() {
        return tasks;
    }

    public void setTasks(List<Item> tasks) {
        this.tasks = tasks;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
