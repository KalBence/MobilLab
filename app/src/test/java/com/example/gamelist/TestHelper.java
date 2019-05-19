package com.example.gamelist;

import org.robolectric.RuntimeEnvironment;
import org.robolectric.shadows.ShadowLog;

import androidx.test.core.app.ApplicationProvider;

public class TestHelper {

    public static DaggerTestComponent setTestInjector() {
        ShadowLog.stream = System.out;
        GameListApplication application = ApplicationProvider.getApplicationContext();
        GameListApplicationComponent injector = DaggerTestComponent.builder().testModule(new TestModule(application.getApplicationContext())).build();
        application.injector = injector;
        return (DaggerTestComponent) injector;
    }
}
