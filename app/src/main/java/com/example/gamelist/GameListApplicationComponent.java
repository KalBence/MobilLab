package com.example.gamelist;

import com.example.gamelist.interactors.games.GamesInteractor;
import com.example.gamelist.ui.UIModule;
import com.example.gamelist.ui.gameCreate.GameCreateActivity;
import com.example.gamelist.ui.gameDetails.GameDetailsActivity;
import com.example.gamelist.ui.main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {UIModule.class})
public interface GameListApplicationComponent {
    void inject(MainActivity activity);

    void inject(GameCreateActivity activity);

    void inject(GameDetailsActivity activity);

    void inject(GamesInteractor interactor);
}