package com.example.gamelist.ui.gameCreate;

import com.example.gamelist.model.Game;
import com.example.gamelist.ui.gameDetails.GameDetailsPresenter;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;

public class GameCreateActivity extends AppCompatActivity implements GameCreateScreen{

    @Inject
    GameCreatePresenter createPresenter;

    @Override
    protected void onStart() {
        super.onStart();
        createPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        createPresenter.detachScreen();
    }


    @Override
    public void NavigateBack() {
        //TODO: navigate back
    }

    @Override
    public void CreateGame(Game newGame) {
        //TODO: save game
    }
}
