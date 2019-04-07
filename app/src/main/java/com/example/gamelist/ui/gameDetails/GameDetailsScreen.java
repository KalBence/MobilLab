package com.example.gamelist.ui.gameDetails;

public interface GameDetailsScreen {
    //navigates back to the list view
    void NavigateBack();

    //shows the details of the selected game
    void showGameDetails(Object gameDetails);
}
