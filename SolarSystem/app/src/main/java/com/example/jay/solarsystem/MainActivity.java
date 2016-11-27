package com.example.jay.solarsystem;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {


    String planets[]={"Mercury","Venus","Earth","Mars","Jupiter","Satrun","Uranus","Neptune"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         ListView listview = (ListView)findViewById(R.id.listView);
        listview.setAdapter(new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1, planets));
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int 				position, long id) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(MainActivity.this,Mercury.class));
                        break;
                    case 1:
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://view.fdu.edu/default.aspx?id=3815")));
                        break;
                    default:
                }
            }
        });




    }
}
