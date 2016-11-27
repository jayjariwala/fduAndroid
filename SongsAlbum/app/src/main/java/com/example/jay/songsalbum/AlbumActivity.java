package com.example.jay.songsalbum;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
public class AlbumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);
        ImageView imageview=(ImageView)findViewById(R.id.imageView);
        Bundle extras=getIntent().getExtras();
        if(extras!=null)
        {
            int play = extras.getInt("song");
            int cover=extras.getInt("cover");
            imageview.setImageResource(cover);
            MediaPlayer media=MediaPlayer.create(this,play);
            media.start();

        }
    }
}
