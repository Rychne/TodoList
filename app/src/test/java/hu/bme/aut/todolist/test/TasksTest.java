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
import hu.bme.aut.todolist.ui.main.MainPresenter;
import hu.bme.aut.todolist.ui.main.MainScreen;

import static hu.bme.aut.todolist.TestHelper.setTestInjector;
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


    @After
    public void tearDown() {
        mainPresenter.detachScreen();
    }
}
