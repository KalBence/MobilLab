package com.example.gamelist.interactors.games;

import com.example.gamelist.GameListApplication;
import com.example.gamelist.model.Game;
import com.example.gamelist.network.GamesApi;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Response;

import static com.example.gamelist.network.NetworkConfig.API_KEY;

public class GamesInteractor {

    GamesApi gamesApi;

    @Inject
    public GamesInteractor(GamesApi gamesApi) {
        this.gamesApi = gamesApi;
        GameListApplication.injector.inject(this);
    }

    public void GetGames() {
        Call<List<Game>> GamesCall = gamesApi.getGames(API_KEY, "fields name,rating,cover,involved_companies,summary,url; limit 10;");

        try {
            Response<List<Game>> response = GamesCall.execute();

        } catch (Exception e) {

        }
    }

    public void CreateGame() {
        //TODO: create new game
    }
}
