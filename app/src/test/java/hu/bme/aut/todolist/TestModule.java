package hu.bme.aut.todolist;

import android.content.Context;

import java.util.concurrent.Executor;
import hu.bme.aut.todolist.network.Execute;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.bme.aut.todolist.utils.UiExecutor;

@Module
public class TestModule {

    private Context context;

    public TestModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    @Execute
    public Executor provideNetworkExecutor() {
        return new UiExecutor();
    }

}
