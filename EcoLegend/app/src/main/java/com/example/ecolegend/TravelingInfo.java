package com.example.ecolegend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;

import android.view.View;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.ImageButton;
import android.widget.TextView;

public class TravelingInfo extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traveling_info);

        TextView label = (TextView) findViewById(R.id.travelLabel);

        final Spinner carType = (Spinner) findViewById(R.id.carList);
        ArrayAdapter<String> car = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.carType));
        car.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        carType.setAdapter(car);

        final Spinner publicTransport = (Spinner) findViewById(R.id.publicTrans);
        ArrayAdapter<String> publicTransportation = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.publicType));
        publicTransportation.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        publicTransport.setAdapter(publicTransportation);

        double toCO2 = 0;
        double mpg = 0;
        if (carType.getSelectedItem().toString() == "Normal Car" )
            toCO2 = 19.6;
        mpg = 25;
        if (carType.getSelectedItem().toString() == "Hybrid Car" )
            toCO2 = 19.6;
        mpg = 50;

        if (carType.getSelectedItem().toString() == "Electric Car" )
            label.setText("Your carbon produced will calculated in your electricity.");
        if (publicTransport.getSelectedItem().toString() == "Train" )
            toCO2 = .2623;
            mpg = .471;
        if (publicTransport.getSelectedItem().toString() == "Bus" )
            toCO2 = .1235;
            mpg = 5;
        if (publicTransport.getSelectedItem().toString() == "Plane" )
            toCO2 = .3873;
            mpg = 64;

        SharedPreferences sharedPreferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putFloat("toC02", (float)toCO2);
        editor.putFloat("mpg", (float)mpg);
        editor.apply();

        final ImageButton travel = (ImageButton) findViewById(R.id.imageButton2);
        travel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                //editor.putString("transportion",publicTransport);
                startActivity(new Intent(TravelingInfo.this, CarTimer.class));
           }
       });

    }
}
