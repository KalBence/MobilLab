package com.example.gamelist.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.gamelist.R;
import com.example.gamelist.model.GameViewModel;

import java.util.List;

import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends AppCompatActivity implements MainScreen {

    private GameViewModel mGameViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //mGameViewModel = ViewModelProviders.of(this).get(GameViewModel.class);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void ShowGames(List<Object> games) {
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
