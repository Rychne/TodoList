package hu.bme.aut.todolist;

import android.app.Application;

import hu.bme.aut.todolist.ui.UIModule;

public class TodoListApplication extends Application {
    public static TodoListApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();
        injector = DaggerTodoListApplicationComponent
                        .builder()
                        .uIModule(new UIModule(this))
                        .build();
    }
}
