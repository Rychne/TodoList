package hu.bme.aut.todolist.orm;

import android.content.Context;

import androidx.room.Room;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ORMModule {
    @Provides
    @Singleton
    public TodoDataBase provideDataBase(Context context) {
        return Room.databaseBuilder(context, TodoDataBase.class, "todo-db").build();
    }
}
