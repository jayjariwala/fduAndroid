package com.example.jay.tunebox;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class video extends AppCompatActivity {
    private int playing=0;
    private Button playvideo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        playvideo=(Button) findViewById(R.id.videoPlay);

        playvideo.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v)
            {
                switch (playing)
                {

                    case 0: VideoView video=(VideoView)findViewById(R.id.videoView);
                            MediaController mediaController=new MediaController(video.this);
                            mediaController.setAnchorView(video);
                            video.setMediaController(mediaController);
                            video.setVideoPath("storage/sdcard/Movies/weekend.mp4");
                            video.start();
                            playing=1;
                            playvideo.setText("STOP");
                            return;

                    case 1: VideoView video1=(VideoView)findViewById(R.id.videoView);
                            video1.stopPlayback();
                             playing=0;
                            playvideo.setText("Play");
                            return;

                }



            }
        });

    }
}
