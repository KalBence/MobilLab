package com.example.gamelist.model;

import android.app.Application;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class GameViewModel extends AndroidViewModel {

    private GameRepository mRepository;

    private LiveData<List<Game>> mAllWords;

    public GameViewModel (Application application) {
        super(application);
        mRepository = new GameRepository(application);
        mAllWords = mRepository.getAllGames();
    }

    public LiveData<List<Game>> getAllGames() { return mAllWords; }

    public void insert(Game game) { mRepository.insert(game); }
}
