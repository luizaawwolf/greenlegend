package com.example.ecolegend;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class traveling_calculation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traveling_calculation);

        Spinner carType = (Spinner) findViewById(R.id.carList);
        ArrayAdapter<String> car = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.carType));
        car.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        carType.setAdapter(car);

        Spinner publicTransport = (Spinner) findViewById(R.id.publicTrans);
        ArrayAdapter<String> publicTransportation = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.publicType));
        car.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        carType.setAdapter(publicTransportation);
    }
}
