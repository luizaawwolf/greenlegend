package com.example.ecolegend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

public class CarbonProduced extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carbon_produced);
        SharedPreferences sharedPreferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE);
        int time = (int)sharedPreferences.getLong("tempTime", (long)0.0)/60000; //in minutes
        Log.d("myTag", "time: " + time);
    }
}
