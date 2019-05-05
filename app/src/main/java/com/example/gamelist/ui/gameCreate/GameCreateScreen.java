package com.example.gamelist.ui.gameCreate;

import com.example.gamelist.model.Game;

public interface GameCreateScreen {
    //navigates back to the list view
    void NavigateBack();

    //creates the new game
    void CreateGame(Game newGame);
}
