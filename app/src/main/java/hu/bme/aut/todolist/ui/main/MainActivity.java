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
    private FloatingActionButton createTaskButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TodoListApplication.injector.inject(this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Task task = new Task();
        task.setName("Paint the flat");
        task.setId("24332");
        task.setDueComplete(false);
        Task task1 = new Task();
        task1.setName("Paint the kitchen");
        task1.setId("24332");
        task1.setDueComplete(true);
        tasksList = Arrays.asList(task, task, task, task1);

//        tasksList = new ArrayList<>();
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
