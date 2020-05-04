package hu.bme.aut.todolist.ui;

import android.content.Context;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.bme.aut.todolist.network.Execute;

@Module
public class UIModule {
    private Context context;

    public UIModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }



    @Provides
    @Singleton
    @Execute
    public Executor provideExecutor() {
        return Executors.newFixedThreadPool(1);
    }
}
