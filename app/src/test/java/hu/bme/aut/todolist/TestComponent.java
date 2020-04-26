package hu.bme.aut.todolist;

import dagger.Component;
import hu.bme.aut.todolist.mock.MockNetworkModule;
import hu.bme.aut.todolist.mock.MockORMModule;

@Component(modules = {MockNetworkModule.class, MockORMModule.class, TestModule.class})
public class TestComponent {

}
