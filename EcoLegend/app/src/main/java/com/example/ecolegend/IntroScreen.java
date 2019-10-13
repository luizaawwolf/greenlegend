package com.example.ecolegend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class IntroScreen extends AppCompatActivity {
    public static final String SHARED_PREFS = "sharedPrefs";
    private EditText userName;
    private EditText birthdayField;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_screen);

        final ImageButton button = findViewById(R.id.nextButton1);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                saveData();
                startActivity(new Intent(IntroScreen.this, IntroInfo.class));
            }
        });
        userName = (EditText) findViewById(R.id.nameField);
        birthdayField = (EditText) findViewById(R.id.birthdayField);

    }
     public void saveData(){
         SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
         SharedPreferences.Editor editor = sharedPreferences.edit();
         editor.putString("name", userName.getText().toString());
         editor.putString("birthday", birthdayField.getText().toString());
         editor.putInt("userLevel", 1);
         editor.putFloat("xpStatus", 0);
         editor.putBoolean("userCreated", true);
         editor.apply();
     }
}
