package com.example.gamelist.ui.main;

import java.util.List;

public interface MainScreen {
    //shows the list of games
    void ShowGames(List<Object> games);

    //navigates to the selected game details view
    void ShowGameDetails(String gameId);

    //navigates to the create new game view
    void CreateNewGame();
}
