package com.example.gamelist.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.gamelist.R;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainScreen {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
