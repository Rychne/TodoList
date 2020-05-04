package hu.bme.aut.todolist.interactor.tasks;

public class CreateTaskEvent {
    private int code;
    private Throwable throwable;

    public CreateTaskEvent() {}

    public CreateTaskEvent(int code, Throwable throwable) {
        this.code = code;
        this.throwable = throwable;
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
