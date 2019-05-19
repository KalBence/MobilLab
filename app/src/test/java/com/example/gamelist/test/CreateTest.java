package com.example.gamelist.test;

import com.example.gamelist.DaggerTestComponent;
import com.example.gamelist.GameListApplication;
import com.example.gamelist.model.Game;
import com.example.gamelist.ui.gameCreate.GameCreatePresenter;
import com.example.gamelist.ui.gameCreate.GameCreateScreen;

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
public class CreateTest {
    @Inject
    GameCreatePresenter createPresenter;

    private GameCreateScreen createScreen;

    @Before
    public void setup() {
        DaggerTestComponent injector = setTestInjector();
        injector.inject(this);
        createScreen = mock(GameCreateScreen.class);
        createPresenter.attachScreen(createScreen);
    }

    @Test
    public void testCreateGame() {
        Game g = new Game();
        g.setName("Test Game");
        createScreen.CreateGame(g);
    }


    @After
    public void tearDown() {
        createPresenter.detachScreen();
    }
}
