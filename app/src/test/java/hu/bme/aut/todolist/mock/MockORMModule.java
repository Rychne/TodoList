package hu.bme.aut.todolist.mock;

import android.content.Context;

import androidx.room.Room;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.bme.aut.todolist.orm.TodoDataBase;

@Module
public class MockORMModule {

    @Provides
    @Singleton
    public TodoDataBase provideDataBase(Context context) {
        return Room.databaseBuilder(context, TodoDataBase.class, "test-db").build();
    }
}
