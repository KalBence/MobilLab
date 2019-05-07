package com.example.gamelist.model;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface GameDao {
    @Query("SELECT * FROM game")
    LiveData<List<Game>> getAll();

    @Query("SELECT * FROM game WHERE id LIKE :id LIMIT 1")
    Game findById(String id);

    @Insert
    void insert(Game game);

    @Delete
    void delete(Game game);

    @Query("DELETE FROM game")
    void deleteAll();

    @Insert
    void insertAll(List<Game> games);
}
