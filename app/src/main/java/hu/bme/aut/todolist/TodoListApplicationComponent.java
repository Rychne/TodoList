package hu.bme.aut.todolist;

import javax.inject.Singleton;

import dagger.Component;
import hu.bme.aut.todolist.interactor.details.DetailsInteractor;
import hu.bme.aut.todolist.interactor.tasks.TasksInteractor;
import hu.bme.aut.todolist.network.NetworkModule;
import hu.bme.aut.todolist.ui.UIModule;
import hu.bme.aut.todolist.ui.details.DetailsActivity;
import hu.bme.aut.todolist.ui.main.MainActivity;

@Singleton
@Component(modules = {UIModule.class, NetworkModule.class})
public interface TodoListApplicationComponent {

    void inject(MainActivity mainActivity);
    void inject(TasksInteractor tasksInteractor);

    void inject(DetailsActivity detailsActivity);
    void inject(DetailsInteractor detailsInteractor);

}
