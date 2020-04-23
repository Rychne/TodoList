package hu.bme.aut.todolist.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.List;

import javax.inject.Inject;

import hu.bme.aut.todolist.R;
import hu.bme.aut.todolist.TodoListApplication;
import hu.bme.aut.todolist.model.Item;
import hu.bme.aut.todolist.ui.details.DetailsActivity;

public class MainActivity extends AppCompatActivity implements MainScreen {

    public static final String KEY_TASK_ID = "KEY_TASK_ID";

    @Inject
    MainPresenter mainPresenter;
    private List<Item> tasksList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TodoListApplication.injector.inject(this);
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
    public void showTasks(List<Item> items) {

    }

    @Override
    public void showTaskDetails(String taskId) {
        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
        intent.putExtra(KEY_TASK_ID, taskId);
        startActivity(intent);
    }
}
