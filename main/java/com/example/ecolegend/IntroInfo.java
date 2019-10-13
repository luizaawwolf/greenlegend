package com.example.ecolegend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.*;
import android.widget.TextView;
import android.util.*;

public class IntroInfo extends AppCompatActivity {
    public int i = 1;
    private int which = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_info);
        final ImageButton button = findViewById(R.id.imageButton);
        final TextView information = (TextView) findViewById(R.id.textView4);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                switch (which) {
                    case 0:
                        information.setText("That\'s equal to \n\n" +
                                "\t58,000 miles \n" +
                                "\t14,000 burgers \n" +
                                "\t300,000 smartphone ch.??");
                        which++;
                        break;
                    case 1:
                        information.setText("Welcome, Eco Apprentice...\n\n" +
                                "You are on the first step to becoming an Eco Legend and changing that number");
                        which++;
                        break;
                    case 2:
                        startActivity(new Intent(IntroInfo.this, MainActivity.class));
                        which=0;
                        break;
                }
            }
        });
    }
}
