package hu.bme.aut.todolist.interactor.tasks.events;

public class DeleteTaskEvent {
        private int code;
        private Throwable throwable;
        private String taskId;

        public DeleteTaskEvent() {}

        public DeleteTaskEvent(int code, Throwable throwable, String id) {
            this.code = code;
            this.throwable = throwable;
            this.taskId = id;
        }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
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
