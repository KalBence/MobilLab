package com.example.gamelist.interactors.games;

import com.example.gamelist.GameListApplication;
import com.example.gamelist.interactors.games.event.GetGamesEvent;
import com.example.gamelist.model.Cover;
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
        String text = "fields name,rating,cover,involved_companies,summary,url; limit 10; where rating > 75; sort popularity desc;";
        RequestBody body =
                RequestBody.create(MediaType.parse("text/plain"), text);

        Call<List<Game>> GamesCall = gamesApi.getGames(API_KEY, body);
        GetGamesEvent event = new GetGamesEvent();
        try {
            Response<List<Game>> response = GamesCall.execute();
            if (response.code() != 200) {
                throw new Exception("Result code is not 200");
            }

            for (Game game : response.body()) {
                if (game.getCover() == 0)
                    continue;
                String coverText = "fields url; where id = " + game.getId() + ";";
                RequestBody coverBody =
                        RequestBody.create(MediaType.parse("text/plain"), coverText);
                Call<List<Cover>> coverCall = gamesApi.getCover(API_KEY, coverBody);
                Response<List<Cover>> coverResponse = coverCall.execute();
                if (coverResponse.body().isEmpty()) {
                    game.setCoverUrl("https://via.placeholder.com/150x150");
                    continue;
                }
                game.setCoverUrl("https:" + coverResponse.body().get(0).getUrl());
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
