package hu.bme.aut.todolist;

import javax.inject.Singleton;

import dagger.Component;
import hu.bme.aut.todolist.interactor.details.DetailsInteractor;
import hu.bme.aut.todolist.interactor.tasks.TasksInteractor;
import hu.bme.aut.todolist.network.NetworkModule;
import hu.bme.aut.todolist.orm.ORMModule;
import hu.bme.aut.todolist.orm.TodoDataBase;
import hu.bme.aut.todolist.ui.UIModule;
import hu.bme.aut.todolist.ui.details.DetailsActivity;
import hu.bme.aut.todolist.ui.details.DetailsPresenter;
import hu.bme.aut.todolist.ui.main.MainActivity;
import hu.bme.aut.todolist.ui.main.MainPresenter;
import hu.bme.aut.todolist.ui.main.TaskDialogFragment;
import hu.bme.aut.todolist.ui.main.TaskRecyclerViewAdapter;

@Singleton
@Component(modules = {UIModule.class, NetworkModule.class, ORMModule.class})
public interface TodoListApplicationComponent {

    void inject(MainActivity mainActivity);
    void inject(TasksInteractor tasksInteractor);
    void inject(MainPresenter mainPresenter);

    void inject(DetailsActivity detailsActivity);
    void inject(DetailsInteractor detailsInteractor);

    void inject(TaskDialogFragment taskDialogFragment);

    void inject(TaskRecyclerViewAdapter taskRecyclerViewAdapter);

    void inject(DetailsPresenter detailsPresenter);
}
