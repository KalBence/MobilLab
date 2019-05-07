package com.example.gamelist.network;

import com.example.gamelist.model.Cover;
import com.example.gamelist.model.Game;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface GamesApi {
    @POST("games")
    Call<List<Game>> getGames(@Header("user-key") String authorisation, @Body RequestBody string);

    @POST("covers")
    Call<List<Cover>> getCover(@Header("user-key") String authorisation, @Body RequestBody string);
}
