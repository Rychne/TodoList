package hu.bme.aut.todolist.orm;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import hu.bme.aut.todolist.model.Task;

@Dao
public interface TaskDAO {


    @Query("SELECT * FROM task")
    List<Task> getAll();

    @Query("SELECT * FROM task WHERE id IN (:cardIds)")
    List<Task> loadAllByIds(int[] cardIds);


    @Insert
    void insertAll(Task... tasks);

    @Update
    void update(Task task);

    @Delete
    void delete(Task task);
}
