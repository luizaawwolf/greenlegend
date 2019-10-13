package com.example.ecolegend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class CarbonProduced extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carbon_produced);
        SharedPreferences sharedPreferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE);
        int time = (int)sharedPreferences.getLong("tempTime", (long)0.0)/60000; //in minutes
        Log.d("myTag", "time: " + time);

        float mpg = sharedPreferences.getFloat("mpg", (float) 0.0);
        float C02 = sharedPreferences.getFloat("C02", (float) 0.0);
        EditText milesTraveled = (EditText) findViewById(R.id.milesTraveled);
        int miles = Integer.parseInt(milesTraveled.toString());
        float carbonProduced = ( miles / mpg ) * C02;
        TextView c02produced = (TextView) findViewById(R.id.CO2_produced);
        c02produced.setText("You total produced" +  c02produced + " CO2 from this trip!!");
        ImageButton b = (ImageButton) findViewById(R.id.goHome);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                    startActivity(new Intent(CarbonProduced.this, MainActivity.class));
            }
        });
    }
}
