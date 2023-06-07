package com.example.hhsprime.models;

import android.content.Context;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import com.example.hhsprime.Database;
import java.io.Serializable;
import java.util.List;

@Entity(foreignKeys = {
        @ForeignKey(
                entity = Character.class,
                parentColumns = "id",
                childColumns = "characterId",
                onDelete = ForeignKey.SET_NULL)})

public class Show implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private Integer id;
    private String name;
    @ColumnInfo(name = "NumberOfSeasons")
    private Integer seasons;

    @Ignore
    private Character mainCharacter;
    private Integer characterId;

    //Constructors
    public Show(String name, Integer seasons) {
        this.name = name;
        this.seasons = seasons;
    }

    public Show(String name, Integer seasons, Character mainCharacter) {
        this.name = name;
        this.seasons = seasons;
        this.mainCharacter = mainCharacter;
    }

    //Methods
    public static void addShow(Show show, Context context) {
        if (show != null) {
            Database.getDatabase(context).showDAO().insert(show);
        }
    }
    public static List<Show> getAll(Context context) {
        List<Show> shows = Database.getDatabase(context).showDAO().getAll();
        for (Show show : shows) {
            if (show.characterId != null)
                show.mainCharacter =
                        Database.getDatabase(context).characterDAO().getById(show.characterId);
        }
        return shows;
    }

    //Getters and Setters
    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSeasons(Integer seasons) {
        this.seasons = seasons;
    }
    public Integer getSeasons() {
        return seasons;
    }
    public Character getMainCharacter() {
        return mainCharacter;
    }
    public Integer getCharacterId() {
        return characterId;
    }
    public void setCharacterId(Integer characterId) {
        this.characterId = characterId;
    }

    //toString
    @Override
    public String toString() {
        return "Show{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", seasons=" + seasons +
                ", mainCharacter=" + mainCharacter +
                '}';
    }
}