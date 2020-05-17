package hu.bme.aut.todolist.mock;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import hu.bme.aut.todolist.model.Task;
import hu.bme.aut.todolist.orm.TaskDAO;
import hu.bme.aut.todolist.orm.TodoDataBase;

@Database(entities = Task.class, version = 1)
public abstract class MockTodoDataBase extends TodoDataBase {
}
