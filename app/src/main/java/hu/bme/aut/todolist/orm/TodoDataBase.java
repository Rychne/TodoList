package hu.bme.aut.todolist.orm;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import hu.bme.aut.todolist.model.Task;

@Database(entities = Task.class, version = 1)
public abstract class TodoDataBase extends RoomDatabase {
    public abstract TaskDAO taskDAO();
}
