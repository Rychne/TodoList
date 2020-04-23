package hu.bme.aut.todolist.ui.main;

import java.util.List;

import hu.bme.aut.todolist.model.Item;

public interface MainScreen {

    void showTasks(List<Item> items);
    void showTaskDetails(String taskId);

}
