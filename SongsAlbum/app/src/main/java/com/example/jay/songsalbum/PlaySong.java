package com.example.jay.songsalbum;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PlaySong extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_song);
        Bundle extras=getIntent().getExtras();
        if(extras!=null)
        {
            int play = extras.getInt("song");

           MediaPlayer media=MediaPlayer.create(this,play);
           media.start();
           
        }
    }
}
