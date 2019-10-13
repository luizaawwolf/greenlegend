package com.example.ecolegend;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LaunchActivity extends AppCompatActivity {
    public static final String SHARED_PREFS = "sharedPrefs";
    public boolean userExists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //REMOVE THIS
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        sharedPreferences.edit().clear().commit();
        loadData();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        if( userExists ) {
            //setContentView(R.layout.activity_main);
            startActivity(new Intent(LaunchActivity.this, MainActivity.class));
        } else {
            //setContentView(R.layout.activity_welcome_screen);
            startActivity(new Intent(LaunchActivity.this, WelcomeScreen.class));
        }

    }

    public void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        userExists = sharedPreferences.getBoolean("userCreated",false);
        Log.d("myTag", "exists: " + userExists);
    }
}
