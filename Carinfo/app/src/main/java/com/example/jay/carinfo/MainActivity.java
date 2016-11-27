package com.example.jay.carinfo;

import android.media.Image;
import android.support.v4.hardware.display.DisplayManagerCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView image=(ImageView) findViewById(R.id.myImage);
        LinearLayout Gallery=(LinearLayout) findViewById(R.id.myGallery);
        Integer cars[]= {R.drawable.bugatti,R.drawable.lambirghini};

        for(int i=0;i< 2;i++)
        {
            ImageView thumbnail=new ImageView(this);
            thumbnail.setLayoutParams(new LinearLayout.LayoutParams(150,150));
            thumbnail.setImageResource(cars[i]);
            thumbnail.setTag(i);
            Gallery.addView(thumbnail);
            DisplayMetrics metrics=getResources().getDisplayMetrics();
            int thumbnailImageDpi=(int) (metrics.density*150);
            thumbnail.setLayoutParams(new
                    LinearLayout.LayoutParams(thumbnailImageDpi,
                    thumbnailImageDpi));

        }




    }
}
