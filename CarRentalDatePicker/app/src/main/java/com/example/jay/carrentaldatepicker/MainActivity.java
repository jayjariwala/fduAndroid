package com.example.jay.carrentaldatepicker;

import android.app.DatePickerDialog;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button carpickup;
    Button carreturn;
    Button calcrent;
    TextView pickupDate;
    TextView returnDate;
    TextView showrent;
    Calendar d1;
    Calendar d2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carpickup=(Button) findViewById(R.id.button);
        pickupDate=(TextView)findViewById(R.id.textView3);
        carreturn=(Button)findViewById(R.id.button2);
        returnDate=(TextView)findViewById(R.id.textView5);
        calcrent=(Button)findViewById(R.id.button3);
        showrent=(TextView)findViewById(R.id.textView6);

        carpickup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int currentYear = calendar.get(Calendar.YEAR);
                int currentMonth = calendar.get(Calendar.MONTH);
                int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dlg = new DatePickerDialog(MainActivity.this,setPickupDate, currentYear, currentMonth, currentDay);
                dlg.show();
            }
        });

        carreturn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                Calendar calendar = Calendar.getInstance();
                int currentYear = calendar.get(Calendar.YEAR);
                int currentMonth = calendar.get(Calendar.MONTH);
                int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dlg = new DatePickerDialog(MainActivity.this,setEndDate, currentYear, currentMonth, currentDay);
                dlg.show();
            }
        });

        calcrent.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                if (d2 == null || d1 == null) {
                    showrent.setText("Please select  car pickup and return date");
                } else {
                    long diffdays = (d2.getTimeInMillis() - d1.getTimeInMillis()) / (1000 * 60 * 60 * 24);
                    if(diffdays<0)
                    {
                        showrent.setText("Please select valid dates");
                    }
                    else
                    {
                        long totalrent = (diffdays * 30);
                        showrent.setText("Your total rent for " + diffdays + " is $" + totalrent);
                    }

                }
            }
        });
    }

    DatePickerDialog.OnDateSetListener setPickupDate = new
            DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year, int month, int day) {
                    d1=Calendar.getInstance();
                    d1.set(year,month,day);
                    pickupDate.setText((month+1)+"/"+day+"/"+year);
                }
            };
    DatePickerDialog.OnDateSetListener setEndDate = new
            DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year, int month, int day) {
                    d2=Calendar.getInstance();
                    d2.set(year,month,day);
                    returnDate.setText((month+1)+"/"+day+"/"+year);
                }
            };

}


