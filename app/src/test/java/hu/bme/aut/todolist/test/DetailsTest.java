package hu.bme.aut.todolist.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.RobolectricTestRunner;

import javax.inject.Inject;

import hu.bme.aut.todolist.DaggerTestComponent;
import hu.bme.aut.todolist.model.Task;
import hu.bme.aut.todolist.ui.details.DetailsPresenter;
import hu.bme.aut.todolist.ui.details.DetailsScreen;

import static hu.bme.aut.todolist.TestHelper.setTestInjector;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
public class DetailsTest {

    @Inject
    DetailsPresenter detailsPresenter;
    private DetailsScreen detailsScreen;

    @Before
    public void setUp() {
        DaggerTestComponent injector = setTestInjector();
        injector.inject(this);
        detailsScreen = mock(DetailsScreen.class);
        detailsPresenter.attachScreen(detailsScreen);
    }

    @Test
    public void refreshTaskDetails() {
        String taskId = "getTaskDetails1";
        detailsPresenter.refreshTaskDetails(taskId);
        ArgumentCaptor<Task> taskCaptor = ArgumentCaptor.forClass(Task.class);
        verify(detailsScreen).showTask(taskCaptor.capture());
        assertEquals(taskId, taskCaptor.getValue().getId());
    }

    @After
    public void tearDown() {
        detailsPresenter.detachScreen();
    }

}
