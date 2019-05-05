package com.example.gamelist;

import com.example.gamelist.interactors.games.GamesInteractor;
import com.example.gamelist.network.NetworkModule;
import com.example.gamelist.ui.UIModule;
import com.example.gamelist.ui.gameCreate.GameCreateActivity;
import com.example.gamelist.ui.gameDetails.GameDetailsActivity;
import com.example.gamelist.ui.main.MainActivity;
import com.example.gamelist.ui.main.MainPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {UIModule.class, NetworkModule.class})
public interface GameListApplicationComponent {
    void inject(MainActivity activity);

    void inject(GameCreateActivity activity);

    void inject(GameDetailsActivity activity);

    void inject(GamesInteractor interactor);

    void inject(MainPresenter mainPresenter);

}