package hu.bme.aut.todolist;

import androidx.test.core.app.ApplicationProvider;

import org.robolectric.RuntimeEnvironment;
import org.robolectric.shadows.ShadowLog;

public class TestHelper {

    public static DaggerTestComponent setTestInjector() {
        ShadowLog.stream = System.out;
        TodoListApplication application = ApplicationProvider.getApplicationContext();
        TodoListApplicationComponent injector = DaggerTestComponent.builder().testModule(new TestModule(application.getApplicationContext())).build();
        application.injector = injector;
        return (DaggerTestComponent) injector;
    }
}
