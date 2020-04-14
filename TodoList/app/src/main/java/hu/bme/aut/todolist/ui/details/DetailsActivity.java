package hu.bme.aut.todolist.ui.details;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import hu.bme.aut.todolist.R;
import hu.bme.aut.todolist.model.Item;

public class DetailsActivity extends AppCompatActivity implements DetailsScreen {
    private DetailsPresenter detailsPresenter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_layout);
    }

    @Override
    public void onResume() {
        super.onResume();
        detailsPresenter.attachScreen(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        detailsPresenter.detachScreen();
    }

    @Override
    public void showTask(Item task) {

    }
}
