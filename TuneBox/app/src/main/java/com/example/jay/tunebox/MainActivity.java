package com.example.jay.tunebox;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup selection=(RadioGroup)findViewById(R.id.radioGroup);
                RadioButton choice=(RadioButton)findViewById(selection.getCheckedRadioButtonId());
                if(choice.getText().equals("music"))
                {
                    startActivity(new Intent(MainActivity.this,music.class));

                }
                if(choice.getText().equals("video"))
                {
                    startActivity(new Intent(MainActivity.this,video.class));
                }
            }
        });
    }
}
