package com.example.hhsprime.DAOs;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.example.hhsprime.models.Character;
import java.util.List;

@Dao
public interface CharacterDAO {
    @Insert
    void insert(Character character);
    @Update
    void delete(Character character);
    @Delete
    void update(Character character);
    @Query("SELECT * FROM Character")
    List<Character> getAll();
    @Query("SELECT * FROM Character WHERE id = :id")
    Character getById(int id);
}
