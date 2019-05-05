package com.example.gamelist.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.example.gamelist.GameListApplication;
import com.example.gamelist.R;
import com.example.gamelist.model.Game;
import com.example.gamelist.model.GameViewModel;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainScreen {

    @Inject
    MainPresenter mainPresenter;

    private GameViewModel mGameViewModel;

    public MainActivity()  {
        GameListApplication.injector.inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mGameViewModel = ViewModelProviders.of(this).get(GameViewModel.class);
        List<Game> m = mGameViewModel.getAllGames().getValue();

        setContentView(R.layout.activity_main);
    }

    @Override
    public void onResume() {
        super.onResume();
        mainPresenter.refreshGames();
    }

    @Override
    public void ShowGames(List<Game> games) {
        //TODO: recycler view
    }

    @Override
    public void ShowGameDetails(String gameId) {
        //TODO: navigate
    }

    @Override
    public void CreateNewGame() {
        //TODO: navigate
    }
}
