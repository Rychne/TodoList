package hu.bme.aut.todolist.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import hu.bme.aut.todolist.R;
import hu.bme.aut.todolist.TodoListApplication;
import hu.bme.aut.todolist.model.Task;

public class MainActivity extends AppCompatActivity implements MainScreen {


    @Inject
    MainPresenter mainPresenter;
    private List<Task> tasksList;
    private RecyclerView recyclerView;
    private TaskRecyclerViewAdapter adapter;
    private FloatingActionButton createTaskButton;

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

        createTaskButton = findViewById(R.id.create_float_button);
        createTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TaskDialogFragment().show(getSupportFragmentManager(), TaskDialogFragment.TAG);
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        mainPresenter.attachScreen(this);
        mainPresenter.refreshTasks();
    }

    @Override
    public void onPause() {
        super.onPause();
        mainPresenter.detachScreen();
    }

    @Override
    public void showTasks(List<Task> tasks) {
        adapter.clear();
        adapter.addTasks(tasks);
    }

    @Override
    public void removeTask(String taskId) {
        adapter.remove(taskId);
    }

    @Override
    public void updateTask(Task task) {
        adapter.add(task);
    }

}
