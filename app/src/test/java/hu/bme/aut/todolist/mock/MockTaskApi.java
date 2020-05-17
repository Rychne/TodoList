package hu.bme.aut.todolist.mock;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import hu.bme.aut.todolist.model.Task;
import hu.bme.aut.todolist.network.TaskApi;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MockTaskApi implements TaskApi {
    @Override
    public Call<Task> createTask(String listId, Task body, String key, String token) {
        return null;
    }

    @Override
    public Call<Task> createTask(String listId, Task body, String key, String token, Callback<Call<Void>> cb) {
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
    public Call<List<Task>> getTasks(String boardId, String key, String token) {
        final List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Testing", "testing getTasks"));
        Call<List<Task>> call = new Call<List<Task>>() {
            @Override
            public Response<List<Task>> execute() throws IOException {
                return Response.success(tasks);
            }

            @Override
            public void enqueue(Callback<List<Task>> callback) {

            }

            @Override
            public boolean isExecuted() {
                return false;
            }

            @Override
            public void cancel() {

            }

            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public Call<List<Task>> clone() {
                return null;
            }

            @Override
            public Request request() {
                return null;
            }
        };

        return call;
    }

    @Override
    public Call<Void> getTasks(String boardId, String key, String token, Callback<List<Task>> cb) {
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
