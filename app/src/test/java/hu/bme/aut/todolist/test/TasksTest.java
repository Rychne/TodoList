package hu.bme.aut.todolist.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.RobolectricTestRunner;

import java.util.List;

import javax.inject.Inject;

import hu.bme.aut.todolist.DaggerTestComponent;
import hu.bme.aut.todolist.model.Task;
import hu.bme.aut.todolist.ui.main.MainPresenter;
import hu.bme.aut.todolist.ui.main.MainScreen;

import static hu.bme.aut.todolist.TestHelper.setTestInjector;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
public class TasksTest {
    @Inject
    MainPresenter mainPresenter;
    private MainScreen mainScreen;

    @Before
    public void setUp() {
        DaggerTestComponent injector = setTestInjector();
        injector.inject(this);
        mainScreen = mock(MainScreen.class);
        mainPresenter.attachScreen(mainScreen);
    }

    @Test
    public void getTasks() {
        mainPresenter.refreshTasks();
        ArgumentCaptor<List> artistCaptor = ArgumentCaptor.forClass(List.class);
        verify(mainScreen).showTasks(artistCaptor.capture());
        assertTrue(artistCaptor.getValue().size() > 0);
    }

    @Test
    public void createTask() {
        Task task = new Task("createTaskTest", "Testing the creation of a task");
        mainPresenter.createTask(task);
        ArgumentCaptor<Task> newTaskCaptor = ArgumentCaptor.forClass(Task.class);
        verify(mainScreen).addTask(newTaskCaptor.capture());
        assertEquals(task.getName(), newTaskCaptor.getValue().getName());
    }

    @Test
    public void updateTask() {
        Task task = new Task("updateTaskTest", "Testing the update process");
        mainPresenter.updateTask(task);
        ArgumentCaptor<Task> taskCaptor = ArgumentCaptor.forClass(Task.class);
        verify(mainScreen).updateTask(taskCaptor.capture());
        assertEquals(task.getName(), taskCaptor.getValue().getName());
    }

    @Test
    public void deleteTask() {
        Task task = new Task("updateTaskTest", "Testing the update process");
        task.setId("deleteTask1");
        mainPresenter.deleteTask(task);
        ArgumentCaptor<String> taskIdCaptor = ArgumentCaptor.forClass(String.class);
        verify(mainScreen).removeTask(taskIdCaptor.capture());
        assertEquals(task.getId(), taskIdCaptor.getValue());
    }

    @After
    public void tearDown() {
        mainPresenter.detachScreen();
    }
}
