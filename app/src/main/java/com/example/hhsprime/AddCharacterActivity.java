package com.example.hhsprime;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hhsprime.models.Character;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddCharacterActivity extends AppCompatActivity {

    public void finish(String message) {
        Intent intent = new Intent();
        intent.putExtra("MESSAGE", message);
        setResult(Activity.RESULT_OK, intent);
        super.finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_character);

        findViewById(R.id.addCharacter_save_btn_id)
                .setOnClickListener(view -> {
                    EditText nameET = findViewById(R.id.addCharacter_name_et_id);
                    String nameString = nameET.getText().toString();

                    EditText dateOfBirthET = findViewById(R.id.addCharacter_dayOfBirth_et_id);
                    String dateOfBirth = dateOfBirthET.getText().toString();

                    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                    Date date = null;
                    try {
                        date = formatter.parse(dateOfBirth);
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }

                    //Voeg zelf validatie toe!

                    Character character = new Character (nameString, date);
                    Character.addCharacter(character, this);

                    Toast.makeText(this, R.string.character_added, Toast.LENGTH_SHORT).show();

                    finish("Save OK");
                });

        findViewById(R.id.addCharacter_cancel_btn_id)
                .setOnClickListener(view -> {
                    finish("Cancel OK");
                });
    }
}