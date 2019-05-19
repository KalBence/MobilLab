package com.example.gamelist.ui.main;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.gamelist.GameListApplication;
import com.example.gamelist.R;
import com.example.gamelist.model.Game;
import com.example.gamelist.model.GameViewModel;
import com.example.gamelist.ui.ItemClickListener;
import com.example.gamelist.ui.gameCreate.GameCreateActivity;
import com.example.gamelist.ui.gameDetails.GameDetailsActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainScreen, ItemClickListener {

    @Inject
    MainPresenter mainPresenter;

    private GameViewModel mGameViewModel;
    private List<Game> gameList;
    private List<Game> localGames;
    private GamesAdapter gamesAdapter;
    private RecyclerView recyclerViewGames;

    public MainActivity()  {
        GameListApplication.injector.inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mGameViewModel = ViewModelProviders.of(this).get(GameViewModel.class);
        mGameViewModel.getAllGames().observe(this, new Observer<List<Game>>() {
            @Override
            public void onChanged(@Nullable final List<Game> games) {
                // Update the cached copy of the words in the adapter.
                localGames = games;
            }
        });
        setContentView(R.layout.activity_main);

        recyclerViewGames = (RecyclerView) findViewById(R.id.recyclerViewGames);
        recyclerViewGames.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(RecyclerView.VERTICAL);
        recyclerViewGames.setLayoutManager(llm);

        gameList = new ArrayList<>();
        gamesAdapter = new GamesAdapter(this, gameList);
        gamesAdapter.setClickListener(this);
        recyclerViewGames.setAdapter(gamesAdapter);

        FloatingActionButton fab = findViewById(R.id.btnAdd);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateNewGame();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainPresenter.detachScreen();
    }

    @Override
    public void onResume() {
        super.onResume();
        mainPresenter.refreshGames();
    }

    @Override
    public void ShowGames(List<Game> games) {
        gameList.clear();
        gameList.addAll(games);
        gameList.addAll(localGames);
        gamesAdapter.notifyDataSetChanged();
    }

    @Override
    public void showNetworkError(String errorMsg) {
        /*if (swipeRefreshLayoutArtists != null) {
            swipeRefreshLayoutArtists.setRefreshing(false);
        }*/
        Toast.makeText(MainActivity.this, errorMsg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void CreateNewGame() {
        Intent i = new Intent(this, GameCreateActivity.class);
        startActivity(i);
    }

    @Override
    public void onClick(View view, int position) {
        Game game = gameList.get(position);
        Intent i = new Intent(this, GameDetailsActivity.class);
        i.putExtra("name", game.getName());
        i.putExtra("imageUrl", game.getCoverUrl());
        i.putExtra("rating", game.getRating());
        i.putExtra("summary", game.getSummary());
        i.putExtra("webpage", game.getUrl());

        startActivity(i);
    }
}
