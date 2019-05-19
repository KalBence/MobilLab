package com.example.gamelist.ui.gameCreate;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.gamelist.GameListApplication;
import com.example.gamelist.R;
import com.example.gamelist.model.Game;
import com.example.gamelist.model.GameViewModel;
import com.example.gamelist.ui.gameDetails.GameDetailsPresenter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

public class GameCreateActivity extends AppCompatActivity implements GameCreateScreen{

    @Inject
    GameCreatePresenter createPresenter;

    private GameViewModel mGameViewModel;

    public GameCreateActivity()  {
        GameListApplication.injector.inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        mGameViewModel = ViewModelProviders.of(this).get(GameViewModel.class);

        Button btn = findViewById(R.id.btnSave);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Game newGame = new Game();

                EditText iname = findViewById(R.id.iName);
                newGame.setName(iname.getText().toString());
                EditText icover = findViewById(R.id.iCover);
                newGame.setCoverUrl(icover.getText().toString());
                EditText irating = findViewById(R.id.iRating);
                newGame.setRating(Double.parseDouble(irating.getText().toString()));
                EditText isummary = findViewById(R.id.iSummary);
                newGame.setSummary(isummary.getText().toString());
                EditText iwebpage = findViewById(R.id.iWebpage);
                newGame.setUrl(iwebpage.getText().toString());

                CreateGame(newGame);
            }
        });
    }

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
    public void CreateGame(Game newGame) {
        mGameViewModel.insert(newGame);
    }
}
