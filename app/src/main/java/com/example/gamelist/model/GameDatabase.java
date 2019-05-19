package com.example.gamelist.model;

import android.content.Context;
import android.os.AsyncTask;
import androidx.annotation.NonNull;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Game.class}, version = 2, exportSchema = false)
public abstract  class GameDatabase extends RoomDatabase {
    public abstract GameDao gameDao();

    private static volatile GameDatabase INSTANCE;

    static GameDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (GameDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            GameDatabase.class, "game_database")
                            // Wipes and rebuilds instead of migrating if no Migration object.
                            // Migration is not part of this codelab.
                            /*.fallbackToDestructiveMigration()*/
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {

        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            // If you want to keep the data through app restarts,
            // comment out the following line.
            new PopulateDbAsync(INSTANCE).execute();
        }
    };

    /**
     * Populate the database in the background.
     * If you want to start with more words, just add them.
     */
    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final GameDao mDao;

        PopulateDbAsync(GameDatabase db) {
            mDao = db.gameDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
            /*mDao.deleteAll();

            Game game = new Game();
            game.setId(1);
            game.setName("League of Legends");
            game.setRating(33.0);
            game.setSummary("Lorem Ipsum");
            game.setUrl("www.leagueoflegends.com");
            mDao.insert(game);*/
            return null;
        }
    }
}
