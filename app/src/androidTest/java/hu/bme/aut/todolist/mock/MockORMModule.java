package hu.bme.aut.todolist.mock;

import android.content.Context;

import androidx.room.Room;

import javax.inject.Singleton;

import dagger.Provides;

public class MockORMModule {

    @Provides
    @Singleton
    public MockTodoDataBase provideDataBase(Context context) {
        return Room.databaseBuilder(context, MockTodoDataBase.class, "test-db").build();
    }
}
