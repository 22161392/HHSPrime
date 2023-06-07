package com.example.hhsprime.DAOs;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.hhsprime.models.Show;

import java.util.List;

@Dao
public interface showDAO {
    @Insert
    void insert(Show show);
    @Update
    void delete(Show show);
    @Delete
    void update(Show show);

    @Query("SELECT * FROM Show")
    List<Show> getAll();

    @Query("SELECT * FROM Show WHERE id = :id")
    Show getById(int id);
}
