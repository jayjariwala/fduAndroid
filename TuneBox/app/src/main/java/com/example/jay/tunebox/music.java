package com.example.jay.tunebox;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class music extends AppCompatActivity {

    private MediaPlayer  mp;
    private Button play;
    private int playing=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        mp=MediaPlayer.create(this,R.raw.onedirection);
        play=(Button)findViewById(R.id.MusicButton);
        play.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                switch (playing){
                    case 0:mp.start();
                        playing=1;
                        play.setText("Pause");
                        break;
                    case 1:mp.pause();
                        playing=0;
                        play.setText("Play");
                        break;
                }
            }
        });

    }
}
