package com.example.gamelist.interactors.games.event;

import com.example.gamelist.model.Game;

import java.util.List;

public class GetGamesEvent {
    private int code;
    private List<Game> games;
    private Throwable throwable;

    //<editor-fold desc="Constructors|Getters|Setters">

    public GetGamesEvent() {
    }

    public GetGamesEvent(int code, List<Game> games, Throwable throwable) {
        this.code = code;
        this.games = games;
        this.throwable = throwable;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setArtists(List<Game> artists) {
        this.games = artists;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    //</editor-fold>
}
