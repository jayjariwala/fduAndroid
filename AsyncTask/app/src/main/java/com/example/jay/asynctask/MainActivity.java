package com.example.jay.asynctask;

import android.media.tv.TvContract;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView t1;
    private Button b1,b2;
    private ProgressBar p1;
    DownloadTask downloadTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1= (TextView)findViewById(R.id.textView);
        b1= (Button) findViewById(R.id.button);
        b2= (Button) findViewById(R.id.button2);
        p1 = (ProgressBar) findViewById(R.id.progressBar3);
        p1.setVisibility(ProgressBar.INVISIBLE);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                downloadTask = new DownloadTask();
                downloadTask.execute();
            }
        });



        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadTask.cancel(true);
            }
        });



    }

    private class DownloadTask extends AsyncTask<String,Integer,String>
    {

        @Override
        protected String doInBackground(String... params) {
            for (int i =0 ; i<=100 ; i +=5)
            {
                if(!isCancelled())
                {
                    SystemClock.sleep(100);
                    publishProgress(i);
                }
                else
                {
                    return "cancelled";
                }
            }

            return "Completed";
        }


        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            t1.setText("Downloading..."+values[0]+"%");
            p1.setVisibility(ProgressBar.VISIBLE);
            p1.setProgress(values[0]);
        }


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            p1.setVisibility(ProgressBar.INVISIBLE);
            t1.setText("Download Completed");

        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
            p1.setVisibility(ProgressBar.INVISIBLE);
            t1.setText("Download cancelled");
        }
    }



}


