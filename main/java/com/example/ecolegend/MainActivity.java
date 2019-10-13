package com.example.ecolegend;

import android.content.SharedPreferences;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.*;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.util.*;
import android.os.*;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {
    public static final String SHARED_PREFS = "sharedPrefs";
    public String name;
    public String birthday;
    public int userLevel;
    private ProgressBar xpProgress;
    private float xpStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        loadData();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView userLevelLabel = (TextView) findViewById(R.id.userLevel);
        userLevelLabel.setText(userLevel+"");
        TextView nameLabel = (TextView) findViewById(R.id.nameDisplay);
        nameLabel.setText(name);
        xpProgress = (ProgressBar) findViewById(R.id.progressbar);
        xpProgress.setProgress(80);
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
        xpStatus = sharedPreferences.getFloat("xpStatus",(float)0.4);
        Log.d("myTag", "name: " + name);
        Log.d("myTag", "level: " + userLevel);
    }
}
