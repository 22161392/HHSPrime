package com.example.hhsprime;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.example.hhsprime.DAOs.CharacterDAO;
import com.example.hhsprime.DAOs.showDAO;
import com.example.hhsprime.models.Show;
import com.example.hhsprime.models.Character;

@androidx.room.Database(entities = {Character.class, Show.class}, version = 1, exportSchema = false)
public abstract class Database extends RoomDatabase {
    public abstract CharacterDAO characterDAO();
    public abstract showDAO showDAO();

    public static Database getDatabase(Context context) {
        Database database;
        synchronized (Database.class) {
            database = Room.databaseBuilder(context, Database.class, "PrimeDB")
                    .allowMainThreadQueries()
                    .build();
            return database;
        }
    }
}
