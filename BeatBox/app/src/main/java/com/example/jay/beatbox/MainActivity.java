package com.example.jay.beatbox;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button next=(Button) findViewById(R.id.button);

        next.setOnClickListener(new View.OnClickListener(){

            RadioGroup type=(RadioGroup)findViewById(R.id.RadioGroup);
            public void onClick(View v)
            {
               Log.d("CREATION","CLICKING BUTTON");
              int selectedId= type.getCheckedRadioButtonId();
                RadioButton mediatype= (RadioButton)findViewById(selectedId);
               String selection=(String)mediatype.getText();
                if(selection.equals("radioButton"))
                {
                startActivity(new Intent(MainActivity.this,music.class));
                }
                if(selection.equals("radioButton2"))
                {
                startActivity(new Intent(MainActivity.this, video.class));
                }

            }

        });

    }
}
