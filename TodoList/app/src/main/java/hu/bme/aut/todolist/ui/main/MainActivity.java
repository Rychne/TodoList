package hu.bme.aut.todolist.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.List;

import hu.bme.aut.todolist.R;
import hu.bme.aut.todolist.model.Item;

public class MainActivity extends AppCompatActivity implements MainScreen {
    MainPresenter mainPresenter;
    private List<Item> tasksList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onResume() {
        super.onResume();
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
}
