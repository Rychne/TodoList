package hu.bme.aut.todolist.mock;

import hu.bme.aut.todolist.model.Task;
import hu.bme.aut.todolist.model.TaskList;
import hu.bme.aut.todolist.network.TaskApi;
import retrofit2.Call;
import retrofit2.Callback;

public class MockTaskApi implements TaskApi {
    @Override
    public Call<Void> createTask(String listId, Task body, String key, String token) {
        return null;
    }

    @Override
    public Call<Void> createTask(String listId, Task body, String key, String token, Callback<Call<Void>> cb) {
        return null;
    }

    @Override
    public Call<Void> deleteTask(String cardId, String key, String token) {
        return null;
    }

    @Override
    public Call<Void> deleteTask(String cardId, String key, String token, Callback<Call<Void>> cb) {
        return null;
    }

    @Override
    public Call<Task> getTaskById(String cardId, String key, String token) {
        return null;
    }

    @Override
    public Call<Void> getTaskById(String cardId, String key, String token, Callback<Task> cb) {
        return null;
    }

    @Override
    public Call<TaskList> getTasks(String boardId, String key, String token) {
        return null;
    }

    @Override
    public Call<Void> getTasks(String boardId, String key, String token, Callback<TaskList> cb) {
        return null;
    }

    @Override
    public Call<Void> updateTask(String cardId, Task body, String key, String token) {
        return null;
    }

    @Override
    public Call<Void> updateTask(String cardId, Task body, String key, String token, Callback<Call<Void>> cb) {
        return null;
    }
}
