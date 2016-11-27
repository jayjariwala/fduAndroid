package com.example.jay.customizedialog;


import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by jay on 11/26/16.
 */



public class ColorDialog extends Dialog {


    private SeekBar Redseek,Greenseek,Blueseek;
    private TextView RedText,GreenText,BlueText;
    private Button done, cancel;
    public int color;



    public ColorDialog(Context context)
    {
       super(context);
        setContentView(R.layout.colordialog);
        Redseek =(SeekBar)findViewById(R.id.seekBar4);
        Greenseek =(SeekBar)findViewById(R.id.seekBar5);
        Blueseek =(SeekBar)findViewById(R.id.seekBar6);
        done = (Button) findViewById(R.id.button3);
        cancel = (Button) findViewById(R.id.button4);

        Redseek.setOnSeekBarChangeListener(colorSeekBarChanged);
        Greenseek.setOnSeekBarChangeListener(colorSeekBarChanged);
        Blueseek.setOnSeekBarChangeListener(colorSeekBarChanged);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color= Color.argb(255,Redseek.getProgress(), Greenseek.getProgress(),Blueseek.getProgress());
                dismiss();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel();
            }
        });






    }
    private SeekBar.OnSeekBarChangeListener colorSeekBarChanged =
            new SeekBar.OnSeekBarChangeListener() {
                public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
                    int r, g, b;
                    r = Redseek.getProgress();
                    g = Greenseek.getProgress();
                    b = Blueseek.getProgress();
                    RedText.setText("Red = "+String.valueOf(r));
                    GreenText.setText("Green = "+String.valueOf(g));
                    BlueText.setText("Blue = "+String.valueOf(b));
                }

                public void onStartTrackingTouch(SeekBar arg0) {
                }

                public void onStopTrackingTouch(SeekBar arg0) {
                }
            };


}
