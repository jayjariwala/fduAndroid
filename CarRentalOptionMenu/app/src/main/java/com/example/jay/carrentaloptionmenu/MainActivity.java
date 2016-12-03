package com.example.jay.carrentaloptionmenu;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    AboutCarRental aboutCarRental;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
            SharedPreferences shared =
                    PreferenceManager.getDefaultSharedPreferences(this);
            switch (item.getItemId()) {
                case R.id.about:
                    aboutCarRental = new AboutCarRental(this);
                    aboutCarRental.show();
                    break;

            }
            return true;
        }


}
