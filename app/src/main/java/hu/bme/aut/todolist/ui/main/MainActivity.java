package hu.bme.aut.todolist.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import hu.bme.aut.todolist.R;
import hu.bme.aut.todolist.TodoListApplication;
import hu.bme.aut.todolist.model.Task;
import hu.bme.aut.todolist.ui.details.DetailsActivity;

public class MainActivity extends AppCompatActivity implements MainScreen {

    public static final String KEY_TASK_ID = "KEY_TASK_ID";

    @Inject
    MainPresenter mainPresenter;
    private List<Task> tasksList;
    private RecyclerView recyclerView;
    private TaskRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TodoListApplication.injector.inject(this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tasksList = new ArrayList<>();
        adapter = new TaskRecyclerViewAdapter(tasksList);
        recyclerView = findViewById(R.id.task_list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onResume() {
        super.onResume();
        mainPresenter.refreshTasks();
        mainPresenter.attachScreen(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        mainPresenter.detachScreen();
    }

    @Override
    public void showTasks(List<Task> Tasks) {

    }

    @Override
    public void showTaskDetails(String taskId) {
        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
        intent.putExtra(KEY_TASK_ID, taskId);
        startActivity(intent);
    }
}
