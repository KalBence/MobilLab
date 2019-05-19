package com.example.gamelist.mock;

import com.example.gamelist.model.Cover;
import com.example.gamelist.model.Game;
import com.example.gamelist.network.GamesApi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MockGamesApi implements GamesApi {
    @Override
    public Call<List<Game>> getGames(String authorisation, RequestBody string) {
        final List<Game> mockResult = new ArrayList<Game>();

        Game game = new Game();
        game.setRating(12.0);
        game.setName("Lord of the rings Online");
        game.setId(123456);
        game.setSummary("just a lotr game");
        game.setUrl("www.game.com");

        mockResult.add(game);


        Call<List<Game>> call = new Call<List<Game>>() {
            @Override
            public Response<List<Game>> execute() throws IOException {
                return Response.success(mockResult);
            }

            @Override
            public void enqueue(Callback<List<Game>> callback) {

            }

            @Override
            public boolean isExecuted() {
                return false;
            }

            @Override
            public void cancel() {

            }

            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public Call<List<Game>> clone() {
                return null;
            }

            @Override
            public Request request() {
                return null;
            }
        };

        return call;
    }

    @Override
    public Call<List<Cover>> getCover(String authorisation, RequestBody string) {
        return null;
    }
}
