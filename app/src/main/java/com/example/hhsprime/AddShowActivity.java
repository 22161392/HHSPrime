package com.example.hhsprime;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.example.hhsprime.models.Character;
import com.example.hhsprime.models.Show;

public class AddShowActivity extends AppCompatActivity {
    public void finish(String message) {
        Intent intent = new Intent();
        intent.putExtra("MESSAGE", message);
        setResult(Activity.RESULT_OK, intent);
        super.finish();
    }

    public static boolean stringNotEmptyNoNumbers(String userInput) {
        if (userInput == null || userInput.isEmpty()) {
            return false;
        }
        for (char c : userInput.toCharArray()) {
            if(!java.lang.Character.isAlphabetic(c) && c != ' '){
                return false;
            }
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_show);

        Spinner spinner = findViewById(R.id.addShow_characters_spnr_id);
        ArrayAdapter<Character> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                Character.getAll(this));
        spinner.setAdapter(adapter);

        findViewById(R.id.addShow_save_btn_id)
                .setOnClickListener(view -> {
                    EditText nameET = findViewById(R.id.addShow_name_et_id);
                    EditText seasonsET = findViewById(R.id.addShow_seasons_et_id);
                    Character character = (Character) spinner.getSelectedItem();
                    String nameString = nameET.getText().toString();
                    String seasonsString = seasonsET.getText().toString();
                    int seasonsInt = Integer.parseInt(seasonsString);

                    Show show = new Show(nameString, seasonsInt, character);
                    show.setCharacterId(character.getId());
                    Show.addShow(show, this);

                    if (nameString.isEmpty() || seasonsString.isEmpty()) {
                        Toast.makeText(this, R.string.show_empty, Toast.LENGTH_SHORT).show();
                        return;
                    }
                    finish("Save OK");
                    Toast.makeText(this, R.string.show_added, Toast.LENGTH_SHORT).show();
                });

        findViewById(R.id.addShow_cancel_btn_id)
                .setOnClickListener(view -> {
                    finish("Cancel OK");
                });
    }
}