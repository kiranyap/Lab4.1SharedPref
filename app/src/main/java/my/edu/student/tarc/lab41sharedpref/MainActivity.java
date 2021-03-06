package my.edu.student.tarc.lab41sharedpref;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textViewName;
    private ImageView imageViewProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //linking UI to program
        textViewName = (TextView) findViewById(R.id.textViewName);
        imageViewProfile = (ImageView) findViewById(R.id.imageViewProfile);

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
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();

        //read data from shared preference file
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        //TODO retreive user name and gender

        String name, gender, title ="";

        name = sharedPreferences.getString("name_text", getString(R.string.pref_default_display_name));

        gender = sharedPreferences.getString("gender_list", "-1");

        if(gender.equals("1"))
        {
            title = "Mr.";
            imageViewProfile.setImageResource(R.drawable.male);
        }

        else if (gender.equals("0"))
        {
            title = "Ms.";
            imageViewProfile.setImageResource(R.drawable.female);
        }

        textViewName.setText(title + " " + name);


    }
}
