package com.example.gamelist.ui.main;

import com.example.gamelist.model.Game;

import java.util.List;

public interface MainScreen {
    //shows the list of games
    void ShowGames(List<Game> games);

    //navigates to the selected game details view
    void ShowGameDetails(String gameId);

    //navigates to the create new game view
    void CreateNewGame();
}
