package com.example.gamelist.ui.main;

import com.example.gamelist.di.Network;
import com.example.gamelist.interactors.games.GamesInteractor;
import com.example.gamelist.interactors.games.event.GetGamesEvent;
import com.example.gamelist.ui.Presenter;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.concurrent.Executor;

import javax.inject.Inject;

public class MainPresenter extends Presenter<MainScreen> {
    Executor networkExecutor;
    GamesInteractor gamesInteractor;

    @Inject
    public MainPresenter(@Network Executor networkExecutor, GamesInteractor gamesInteractor) {
        this.networkExecutor = networkExecutor;
        this.gamesInteractor = gamesInteractor;
    }

    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void refreshGames() {
        networkExecutor.execute(new Runnable() {
            @Override
            public void run() {
                gamesInteractor.GetGames();
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final GetGamesEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                //screen.showNetworkError(event.getThrowable().getMessage());
            }
        } else {
            if (screen != null) {
                screen.ShowGames(event.getGames());
            }
        }
    }
}
