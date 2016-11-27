package com.example.jay.tablayoutapp;
import android.app.DatePickerDialog;
import android.content.SharedPreferences;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

/**
 * Created by jay on 11/5/16.
 */
public class FragmentTwo extends Fragment {
       Button pickupSelect;
    Button returnSelect, totalrent;
    TextView startdate, returndate, showprice;
    Calendar d1;
    Calendar d2;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragmenttwo, container, false);
        pickupSelect= (Button) v.findViewById(R.id.button);
        returnSelect = (Button) v.findViewById(R.id.button2);
        startdate =(TextView)v.findViewById(R.id.textView5);
        returndate=(TextView)v.findViewById(R.id.textView6);
        totalrent=(Button)v.findViewById(R.id.button3);
        showprice=(TextView)v.findViewById(R.id.textView7);


        pickupSelect.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v)
            {
                Calendar calendar= Calendar.getInstance();
                int currentYear=calendar.get(Calendar.YEAR);
                int currentMonth=calendar.get(Calendar.MONTH);
                int currentDay= calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dlg= new DatePickerDialog(getActivity(),setpickupDate,currentYear,currentMonth,currentDay);
                dlg.show();
            }

            DatePickerDialog.OnDateSetListener setpickupDate = new
                    DatePickerDialog.OnDateSetListener() {
                        public void onDateSet(DatePicker view, int year, int month, int day) {
                            d1= Calendar.getInstance();
                            d1.set(year,month,day);
                            startdate.setText((month+1)+"/"+day+"/"+year);
                        }
                    };

        });

        returnSelect.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                Calendar calendar= Calendar.getInstance();
                int currentYear=calendar.get(Calendar.YEAR);
                int currentMonth=calendar.get(Calendar.MONTH);
                int currentDay=calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dlg=new DatePickerDialog(getActivity(),setreturnDate,currentYear,currentMonth,currentDay);
                dlg.show();

            }

            DatePickerDialog.OnDateSetListener setreturnDate = new
                    DatePickerDialog.OnDateSetListener() {
                        public void onDateSet(DatePicker view, int year, int month, int day) {
                            d2= Calendar.getInstance();
                            d2.set(year,month,day);
                            returndate.setText((month+1)+"/"+day+"/"+year);
                        }
                    };
        });

        totalrent.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                SharedPreferences shared= PreferenceManager.getDefaultSharedPreferences(getActivity());
                int price=shared.getInt("prefer_int",0);
                if( price == 0 || d1 == null || d2 == null)
                {
                    showprice.setText("Please select All the required fileds");
                }
                long diffdays=((d2.getTimeInMillis() - d1.getTimeInMillis())/(1000 * 60 * 60 * 24));
                if(diffdays <0)
                {
                    showprice.setText("Please select valid dates");
                }
                else
                {
                    long totalrent=(diffdays * price);
                    showprice.setText("Your total rent for "+diffdays+" day is $"+totalrent);
                }


                System.out.println("The price you selected was "+price);
            }
        });

        return v;
    }
}
