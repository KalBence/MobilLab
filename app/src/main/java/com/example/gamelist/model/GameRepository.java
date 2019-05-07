package com.example.gamelist.model;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;

import androidx.lifecycle.LiveData;

public class GameRepository {
    private GameDao mGameDao;
    private LiveData<List<Game>> mAllGames;

    GameRepository(Application application) {
        GameDatabase db = GameDatabase.getDatabase(application);
        mGameDao = db.gameDao();
        mAllGames = mGameDao.getAll();
    }

    LiveData<List<Game>> getAllGames() {
        return mAllGames;
    }

    public void insert (Game game) {
        new insertAsyncTask(mGameDao).execute(game);
    }

    public void insertAll(List<Game> games) {
        new insertAllAsyncTask(mGameDao).execute(games);
    }

    private static class insertAsyncTask extends AsyncTask<Game, Void, Void> {

        private GameDao mAsyncTaskDao;

        insertAsyncTask(GameDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Game... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

    private static class insertAllAsyncTask extends AsyncTask<List<Game>, Void, Void> {

        private GameDao mAsyncTaskDao;

        insertAllAsyncTask(GameDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final List<Game>... params) {
            mAsyncTaskDao.insertAll(params[0]);
            return null;
        }
    }
}
