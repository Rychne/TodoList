package hu.bme.aut.todolist.ui.details;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import javax.inject.Inject;

import hu.bme.aut.todolist.R;
import hu.bme.aut.todolist.TodoListApplication;
import hu.bme.aut.todolist.model.Task;

import static hu.bme.aut.todolist.ui.main.MainActivity.KEY_TASK_ID;

public class DetailsActivity extends AppCompatActivity implements DetailsScreen {

    @Inject
    DetailsPresenter detailsPresenter;
    private String taskId;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_layout);
        TodoListApplication.injector.inject(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        taskId = this.getIntent().getStringExtra(KEY_TASK_ID);
        detailsPresenter.refreshTaskDetails(taskId);
        detailsPresenter.attachScreen(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        detailsPresenter.detachScreen();
    }

    @Override
    public void showTask(Task task) {

    }
}
