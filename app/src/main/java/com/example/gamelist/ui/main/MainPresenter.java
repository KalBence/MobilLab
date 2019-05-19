package com.example.gamelist.ui.main;

import com.example.gamelist.di.Network;
import com.example.gamelist.interactors.games.GamesInteractor;
import com.example.gamelist.interactors.games.event.GetGamesEvent;
import com.example.gamelist.ui.Presenter;

import org.greenrobot.eventbus.EventBus;
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
        EventBus.getDefault().register(this);
    }

    @Override
    public void detachScreen() {
        EventBus.getDefault().unregister(this);
        super.detachScreen();
    }

    public void refreshGames() {
        networkExecutor.execute(new Runnable() {
            @Override
            public void run() {
                gamesInteractor.GetGames("fields name,rating,cover,involved_companies,summary,url; limit 10; where rating > 75; sort popularity desc;");
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
