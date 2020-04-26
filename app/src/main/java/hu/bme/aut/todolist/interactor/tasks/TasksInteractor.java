package hu.bme.aut.todolist.interactor.tasks;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import hu.bme.aut.todolist.TodoListApplication;
import hu.bme.aut.todolist.model.TaskList;
import hu.bme.aut.todolist.network.TaskApi;
import hu.bme.aut.todolist.orm.TodoDataBase;
import retrofit2.Call;
import retrofit2.Response;

import static hu.bme.aut.todolist.network.NetworkConfig.API_KEY;
import static hu.bme.aut.todolist.network.NetworkConfig.BOARD_ID;
import static hu.bme.aut.todolist.network.NetworkConfig.TOKEN;

public class TasksInteractor {

    private final TaskApi taskApi;
    private final TodoDataBase db;

    @Inject
    public TasksInteractor(TaskApi taskApi, TodoDataBase dataBase) {
        this.taskApi = taskApi;
        this.db = dataBase;
        TodoListApplication.injector.inject(this);
    }

    public void getTasks() {
        Call<TaskList> getAllTasksQueryCall = taskApi.getTasks(BOARD_ID, API_KEY, TOKEN);
        GetTasksEvent event = new GetTasksEvent();
        try {
            Response<TaskList> response = getAllTasksQueryCall.execute();
            if (response.code() != 200) {
                throw new Exception("Result code is not 200");
            }
            event.setCode(response.code());
            event.setTasks(response.body().getTasks());
            EventBus.getDefault().post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            EventBus.getDefault().post(event);
        }
    }
}
