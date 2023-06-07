package com.example.hhsprime.models;

import android.content.Context;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;
import com.example.hhsprime.Database;
import com.example.hhsprime.converters.Converter;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Character implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private Integer id;
    private String name;
    @TypeConverters({Converter.class})
    private Date dateOfBirth;

    @Ignore
    public Character(String name) {
        this.name = name;
    }
    public Character(String name, Date dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    //Methods
    public static void addCharacter(Character character, Context context) {
        if (character != null) {
            Database.getDatabase(context).characterDAO().insert(character);
        }
    }
    public static List<Character> getAll(Context context) {
        return Database.getDatabase(context).characterDAO().getAll();
    }

    //Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    //toString
    @Override
    public String toString() {
        return getName();
    }

}
