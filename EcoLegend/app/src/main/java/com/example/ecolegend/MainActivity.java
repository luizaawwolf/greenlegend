package com.example.ecolegend;

import android.content.Intent;
import android.content.SharedPreferences;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.*;
import android.widget.*;
import android.util.*;
import android.os.*;
import android.graphics.Color;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {
    public static final String SHARED_PREFS = "sharedPrefs";
    public String name;
    public String birthday;
    public int userLevel;
    private ProgressBar xpProgress;
    private float xpStatus;
    private int carbonFootprint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        loadData();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView carbonLabel = (TextView) findViewById(R.id.userLevel);
        if( carbonFootprint == 0 ){
            carbonLabel.setText("TAKE THE QUIZ\nTO FIND OUT");
            carbonLabel.setTextSize(15);
            carbonLabel.setTextColor(Color.parseColor("#FFDF6088"));
        } else {
            carbonLabel.setText(carbonFootprint+"");
        }
        Button travelButton = (Button) findViewById(R.id.travelButt);
        travelButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TravelingInfo.class));
            }
        });

        ImageButton quizButton = (ImageButton) findViewById(R.id.quizButton);
        quizButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, QuizTest.class));
            }
        });
//        TextView nameLabel = (TextView) findViewById(R.id.nameDisplay);
//        nameLabel.setText(name);
//        xpProgress = (ProgressBar) findViewById(R.id.progressbar);
//        xpProgress.setProgress(80);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        name = sharedPreferences.getString("name","def");
        userLevel = sharedPreferences.getInt("userLevel", 0);
        carbonFootprint = sharedPreferences.getInt("carbonFootprint", 0);
        xpStatus = sharedPreferences.getFloat("xpStatus",(float)0.4);
        Log.d("myTag", "name: " + name);
        Log.d("myTag", "level: " + userLevel);
    }
}
