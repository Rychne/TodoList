package hu.bme.aut.todolist.ui.details;

import android.os.Bundle;
import android.renderscript.RSInvalidStateException;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.firebase.analytics.FirebaseAnalytics;

import javax.inject.Inject;

import hu.bme.aut.todolist.R;
import hu.bme.aut.todolist.TodoListApplication;
import hu.bme.aut.todolist.model.Task;

public class DetailsActivity extends AppCompatActivity implements DetailsScreen {

    public static final String KEY_TASK_ID = "KEY_TASK_ID";
    @Inject
    DetailsPresenter detailsPresenter;
    private String taskId;
    private FirebaseAnalytics mFirebaseAnalytics;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        TodoListApplication.injector.inject(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

    }

    @Override
    public void onResume() {
        super.onResume();
        taskId = this.getIntent().getStringExtra(KEY_TASK_ID);
        detailsPresenter.attachScreen(this);
        detailsPresenter.refreshTaskDetails(taskId);
    }

    @Override
    public void onPause() {
        super.onPause();
        detailsPresenter.detachScreen();
    }

    @Override
    public void showTask(Task task) {
        Crashlytics.getInstance().crash();
        ((TextView) findViewById(R.id.task_name_textview)).setText(task.getName());
        ((TextView) findViewById(R.id.task_description_textview)).setText(task.getDesc());
    }
}
