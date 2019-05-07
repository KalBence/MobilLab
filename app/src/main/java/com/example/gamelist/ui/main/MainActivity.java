package com.example.gamelist.ui.main;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.gamelist.GameListApplication;
import com.example.gamelist.R;
import com.example.gamelist.model.Game;
import com.example.gamelist.model.GameViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainScreen {

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
        recyclerViewGames.setAdapter(gamesAdapter);
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
    public void ShowGameDetails(String gameId) {
        //TODO: navigate
    }

    @Override
    public void CreateNewGame() {
        //TODO: navigate
    }
}
