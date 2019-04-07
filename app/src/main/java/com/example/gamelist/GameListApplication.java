package com.example.gamelist;

import android.app.Application;

import com.example.gamelist.ui.UIModule;

public class GameListApplication extends Application {

    public static GameListApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        injector = DaggerGameListApplicationComponent.builder().
                        uIModule(
                                new UIModule(this)
                        ).build();

    }
}
