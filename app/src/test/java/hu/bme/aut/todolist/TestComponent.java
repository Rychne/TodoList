package hu.bme.aut.todolist;


import javax.inject.Singleton;

import dagger.Component;
import hu.bme.aut.todolist.mock.MockNetworkModule;
import hu.bme.aut.todolist.mock.MockORMModule;
import hu.bme.aut.todolist.test.TasksTest;

@Singleton
@Component(modules = {MockNetworkModule.class, MockORMModule.class, TestModule.class})
public interface TestComponent extends TodoListApplicationComponent {
    void inject(TasksTest tasksTest);
}


