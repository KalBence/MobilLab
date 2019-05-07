package com.example.gamelist.interactors.games;

import com.example.gamelist.GameListApplication;
import com.example.gamelist.interactors.games.event.GetGamesEvent;
import com.example.gamelist.model.Game;
import com.example.gamelist.network.GamesApi;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import javax.inject.Inject;

import okhttp3.MediaType;
import okhttp3.RequestBody;
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
        String text = "fields name,rating,cover,involved_companies,summary,url; limit 30; where rating > 75;";
        RequestBody body =
                RequestBody.create(MediaType.parse("text/plain"), text);

        Call<List<Game>> GamesCall = gamesApi.getGames(API_KEY, body);
        GetGamesEvent event = new GetGamesEvent();
        try {
            Response<List<Game>> response = GamesCall.execute();
            if (response.code() != 200) {
                throw new Exception("Result code is not 200");
            }
            event.setCode(response.code());
            event.setGames(response.body());
            EventBus.getDefault().post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            EventBus.getDefault().post(event);
        }
    }

    public void CreateGame() {
        //TODO: create new game
    }
}
