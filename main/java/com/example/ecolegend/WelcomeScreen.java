package com.example.ecolegend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.view.View;
import android.content.Intent;

public class WelcomeScreen extends AppCompatActivity {
    public static final String SHARED_PREFS = "sharedPrefs";
    public boolean userExists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        loadData();
        final Button button = findViewById(R.id.beginbutton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if( userExists ){
                    startActivity(new Intent(WelcomeScreen.this, MainActivity.class));
                }
                else {
                    startActivity(new Intent(WelcomeScreen.this, IntroScreen.class));
                }
            }
        });
    }

    public void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        userExists = sharedPreferences.getBoolean("userCreated",false);
        Log.d("myTag", "exists: " + userExists);
    }
}
