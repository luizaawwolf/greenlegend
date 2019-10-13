package com.example.ecolegend;

import androidx.appcompat.app.AppCompatActivity;

import android.os.SystemClock;
import android.view.*;
import android.os.Bundle;
import android.widget.Chronometer;

public class car_timer extends AppCompatActivity {
    private Chronometer chronometer;
    private long pauseOffset;
    private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_timer);

        chronometer = findViewById(R.id.chronometer);
        chronometer.setFormat("Time: %s");
    }
    public void startChronometer(View v){
        if(!running){
            chronometer.setBase(SystemClock.elapsedRealtime()-pauseOffset);
            chronometer.start();
            running = true;
        }
    }
    public void pauseChronometer(View v){
        if (running){

            chronometer.stop();
            //This time stop
            pauseOffset = SystemClock.elapsedRealtime() - chronometer.getBase();
            running = false;
        }
    }
    public void resetChronometer(View v){
        chronometer.setBase(SystemClock.elapsedRealtime());
        pauseOffset = 0;
    }
}
