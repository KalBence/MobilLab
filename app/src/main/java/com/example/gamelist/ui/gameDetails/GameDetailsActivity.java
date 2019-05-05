package com.example.gamelist.ui.gameDetails;

import android.os.Bundle;

import com.example.gamelist.R;
import com.example.gamelist.model.Game;
import com.example.gamelist.model.GameViewModel;

import java.util.List;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

public class GameDetailsActivity extends AppCompatActivity implements GameDetailsScreen {

    @Inject
    GameDetailsPresenter detailsPresenter;

    private GameViewModel mGameViewModel;
    private Game selectedGame;

    @Override
    protected void onStart() {
        super.onStart();
        detailsPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        detailsPresenter.detachScreen();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mGameViewModel = ViewModelProviders.of(this).get(GameViewModel.class);
        //selectedGame = mGameViewModel.getAllGames().getValue().get(id);
    }

    @Override
    public void NavigateBack() {
        //TODO: navigate back
    }

    @Override
    public void showGameDetails(Object gameDetails) {
        //TODO: show game details -  data in selectedGame
    }
}
