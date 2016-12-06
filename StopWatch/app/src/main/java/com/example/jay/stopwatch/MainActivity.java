package com.example.jay.stopwatch;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView t1;
    Button start,reset;
    setTimer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = (TextView) findViewById(R.id.textView2);
        start = (Button) findViewById(R.id.button);
        reset =(Button) findViewById(R.id.button2);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                timer= new setTimer();
                start.setText("Pause");
                String buttontext= start.getText().toString();
                long timelepsed= System.currentTimeMillis();
                timer.execute(""+timelepsed,buttontext);

            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel(true);
            }
        });
    }

    private class setTimer extends AsyncTask <String,Integer,String>
    {


        @Override
        protected String doInBackground(String... params) {



                while (!isCancelled()) {

                            if(params[1].toString().equals("PAUSE"))
                            {
                                System.out.println("Print something");
                            }

                            System.out.println("The String"+params[1]);
                            long Starttime=Long.parseLong(params[0]);
                            System.out.println("Print date"+Starttime);
                            long timelepsed= System.currentTimeMillis() - Starttime;
                            int hundreths=(int)((timelepsed % 1000)/10);
                            int seconds = (int)((timelepsed % 60000) / 1000);
                            int minutes = (int)(timelepsed / 60000);
                            int hr= (int)(timelepsed / (1000 * 60 * 60) % 24);
                            publishProgress(hr,minutes,seconds,hundreths);


                }

                    return "Cancelled";


        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            String stopwatch= String.format("%02d:%02d:%02d.%02d",values[0],values[1],values[2],values[3]);
            t1.setText(stopwatch);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
            String stopwatch= String.format("%02d:%02d:%02d.%02d",0,0,0,0);
            t1.setText(stopwatch);


        }




    }

}

