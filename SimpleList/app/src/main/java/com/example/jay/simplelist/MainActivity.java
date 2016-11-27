package com.example.jay.simplelist;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] carmodel={"Ferrari", "Bugatti", "Lamborghini"};
        final Integer[] images={R.drawable.ferrari,R.drawable.bugatti,R.drawable.lambirghini};

        ArrayList<RowItem> rowitems = new ArrayList<RowItem>();
        rowitems.add(new RowItem(images[0],carmodel[0]));
        rowitems.add(new RowItem(images[1],carmodel[1]));
        rowitems.add(new RowItem(images[2],carmodel[2]));


        ListView list= (ListView) findViewById(R.id.listView);
        list.setAdapter((ListAdapter) new CustomListAdapter(this,rowitems));

        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        startActivity(new Intent(MainActivity.this,Ferrari.class));
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this,Bugatti.class));
                        break;
                    case 2:
                        startActivity(new Intent(MainActivity.this,Lamborghini.class));
                        break;
                }
            }
        });

    }
}
