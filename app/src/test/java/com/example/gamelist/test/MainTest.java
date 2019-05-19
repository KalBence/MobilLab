package com.example.gamelist.test;

import com.example.gamelist.DaggerTestComponent;
import com.example.gamelist.GameListApplication;
import com.example.gamelist.ui.main.MainPresenter;
import com.example.gamelist.ui.main.MainScreen;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.List;

import javax.inject.Inject;

import static com.example.gamelist.TestHelper.setTestInjector;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
@Config(application = GameListApplication.class)
public class MainTest {
    @Inject
    MainPresenter mainPresenter;

    private MainScreen mainScreen;

    @Before
    public void setup() {
        DaggerTestComponent injector = setTestInjector();
        injector.inject(this);
        mainScreen = mock(MainScreen.class);
        mainPresenter.attachScreen(mainScreen);
    }

    @Test
    public void testGameApiCall() {
        mainPresenter.refreshGames();;

        ArgumentCaptor<List> gameCaptor = ArgumentCaptor.forClass(List.class);
        verify(mainScreen).ShowGames(gameCaptor.capture());
        assertTrue(gameCaptor.getValue().size() > 0);
    }


    @After
    public void tearDown() {
        mainPresenter.detachScreen();
    }

}
