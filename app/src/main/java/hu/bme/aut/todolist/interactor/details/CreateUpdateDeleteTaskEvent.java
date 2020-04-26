package hu.bme.aut.todolist.interactor.details;

class CreateUpdateDeleteTaskEvent {

    private int code;
    private Throwable throwable;

    public CreateUpdateDeleteTaskEvent() {
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
