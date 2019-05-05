package com.example.gamelist.mock;

import com.example.gamelist.network.GamesApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class MockNetworkModule {

    @Provides
    @Singleton
    public Retrofit.Builder provideRetrofit() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create());

    }

    @Provides
    @Singleton
    public GamesApi provideArtistsApi(Retrofit.Builder retrofitBuilder) {
        return new MockGamesApi();
    }

}
