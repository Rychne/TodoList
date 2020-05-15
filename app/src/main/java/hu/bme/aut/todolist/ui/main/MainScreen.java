package hu.bme.aut.todolist.ui.main;

import java.util.List;

import hu.bme.aut.todolist.model.Task;

public interface MainScreen {

    void showTasks(List<Task> items);

    void addTask(Task item);

    void removeTask(String taskId);

    void updateTask(Task task);

}
