package hu.bme.aut.todolist.interactor.tasks;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import javax.inject.Inject;

import hu.bme.aut.todolist.TodoListApplication;
import hu.bme.aut.todolist.model.Task;
import hu.bme.aut.todolist.network.TaskApi;
import hu.bme.aut.todolist.orm.TodoDataBase;
import retrofit2.Call;
import retrofit2.Response;

import static hu.bme.aut.todolist.network.NetworkConfig.API_KEY;
import static hu.bme.aut.todolist.network.NetworkConfig.BOARD_ID;
import static hu.bme.aut.todolist.network.NetworkConfig.LIST_ID;
import static hu.bme.aut.todolist.network.NetworkConfig.TOKEN;

public class TasksInteractor {
    private static final String TAG = TasksInteractor.class.getSimpleName();

    private final TaskApi taskApi;
    private final TodoDataBase db;

    @Inject
    public TasksInteractor(TaskApi taskApi, TodoDataBase dataBase) {
        this.taskApi = taskApi;
        this.db = dataBase;
        TodoListApplication.injector.inject(this);
    }

    public void getTasks() {
        Call<List<Task>> getAllTasksQueryCall = taskApi.getTasks(BOARD_ID, API_KEY, TOKEN);
        GetTasksEvent event = new GetTasksEvent();
        try {
            Response<List<Task>> response = getAllTasksQueryCall.execute();
            if (response.code() != 200) {
                throw new Exception("Result code is not 200");
            }
            event.setCode(response.code());
            event.setTasks(response.body());
            EventBus.getDefault().post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            EventBus.getDefault().post(event);
        }
    }

    public void createTask(Task task) {
        task.setIdList(LIST_ID);
        Call<Void> createTaskQueryCall = taskApi.createTask(LIST_ID, task, API_KEY, TOKEN);
        CreateTaskEvent event = new CreateTaskEvent();
        try {
            Response<Void> response = createTaskQueryCall.execute();
            if (response.code() != 200) {
                throw new Exception("Result code is not 200");
            }
            event.setCode(response.code());
            EventBus.getDefault().post(event);
        } catch (Exception e) {
            e.printStackTrace();
            event.setThrowable(e);
            EventBus.getDefault().post(event);
        }
    }

    public void updateTask(Task task) {
        db.taskDAO().update(task);
        //TODO
    }

    public void delete(Task task) {
        db.taskDAO().delete(task);
        //TODO
    }
}
