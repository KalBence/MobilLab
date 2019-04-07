package com.example.gamelist.ui.main;

import com.example.gamelist.ui.Presenter;

import javax.inject.Inject;

public class MainPresenter extends Presenter<MainScreen> {
    @Inject
    public MainPresenter() {
    }

    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }
}
