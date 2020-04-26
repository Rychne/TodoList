package hu.bme.aut.todolist.mock;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import hu.bme.aut.todolist.model.Task;
import hu.bme.aut.todolist.orm.TaskDAO;

@Database(entities = Task.class, version = 1)
public abstract class MockTodoDataBase extends RoomDatabase {
    public abstract TaskDAO taskDAO();
}
