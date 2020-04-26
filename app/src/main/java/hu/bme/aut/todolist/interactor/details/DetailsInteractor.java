package hu.bme.aut.todolist.interactor.details;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import hu.bme.aut.todolist.TodoListApplication;
import hu.bme.aut.todolist.model.Task;
import hu.bme.aut.todolist.network.TaskApi;
import hu.bme.aut.todolist.orm.TodoDataBase;
import retrofit2.Call;
import retrofit2.Response;

import static hu.bme.aut.todolist.network.NetworkConfig.API_KEY;
import static hu.bme.aut.todolist.network.NetworkConfig.LIST_ID;
import static hu.bme.aut.todolist.network.NetworkConfig.TOKEN;

public class DetailsInteractor {
    TaskApi taskApi;
    TodoDataBase db;

    @Inject
    public DetailsInteractor(TaskApi taskApi, TodoDataBase dataBase) {
        this.taskApi = taskApi;
        this.db = dataBase;
        TodoListApplication.injector.inject(this);
    }

    public void getTaskDetails(String taskDetailsQuery) {
        Call<Task> getTaskQueryCall = taskApi.getTaskById(taskDetailsQuery, API_KEY, TOKEN);
        GetTaskDetailsEvent event = new GetTaskDetailsEvent();
        try {
            Response<Task> response = getTaskQueryCall.execute();
            if (response.code() != 200) {
                throw new Exception("Result code is not 200");
            }
            event.setCode(response.code());
            event.setTaskDetails(response.body());
            EventBus.getDefault().post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            EventBus.getDefault().post(event);
        }
    }

    public void createTask(Task task) {
        Call<Void> createTaskQueryCall = taskApi.createTask(LIST_ID, task, API_KEY, TOKEN);
        CreateUpdateDeleteTaskEvent event = new CreateUpdateDeleteTaskEvent();
        try {
            Response<Void> response = createTaskQueryCall.execute();
            if (response.code() != 200) {
                throw new Exception("Result code is not 200");
            }
            event.setCode(response.code());
            EventBus.getDefault().post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            EventBus.getDefault().post(event);
        }
    }

    public void updateTask(Task task) {
        Call<Void> updateTaskQueryCall = taskApi.updateTask(task.getId(), task, API_KEY, TOKEN);
        CreateUpdateDeleteTaskEvent event = new CreateUpdateDeleteTaskEvent();
        try {
            Response<Void> response = updateTaskQueryCall.execute();
            if (response.code() != 200) {
                throw new Exception("Result code is not 200");
            }
            event.setCode(response.code());
            EventBus.getDefault().post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            EventBus.getDefault().post(event);
        }
    }

    public void deleteTask(String id) {

        Call<Void> deleteTaskQueryCall = taskApi.deleteTask(id, API_KEY, TOKEN);
        CreateUpdateDeleteTaskEvent event = new CreateUpdateDeleteTaskEvent();
        try {
            Response<Void> response = deleteTaskQueryCall.execute();
            if (response.code() != 200) {
                throw new Exception("Result code is not 200");
            }
            event.setCode(response.code());
            EventBus.getDefault().post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            EventBus.getDefault().post(event);
        }
    }
}
