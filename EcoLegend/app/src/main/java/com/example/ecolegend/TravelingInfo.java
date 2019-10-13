package com.example.ecolegend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;

import android.view.View;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.ImageButton;

public class TravelingInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traveling_info);

        Spinner carType = (Spinner) findViewById(R.id.carList);
        ArrayAdapter<String> car = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.carType));
        car.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        carType.setAdapter(car);

        final Spinner publicTransport = (Spinner) findViewById(R.id.publicTrans);
        ArrayAdapter<String> publicTransportation = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.publicType));
        publicTransportation.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        publicTransport.setAdapter(publicTransportation);

        final ImageButton travel = (ImageButton) findViewById(R.id.imageButton2);
        travel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                //editor.putString("transportion",publicTransport)
           }
       });
    }
}
