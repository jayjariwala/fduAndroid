package com.example.jay.carrental;
import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button showprice=(Button)findViewById(R.id.totalpriceButton);
        final TextView displaycost=(TextView) findViewById(R.id.showprice);
        displaycost.setText("");
        showprice.setOnClickListener(new View.OnClickListener() {

            private void displaycost(double totalcost,String cartype,String carmodel,int days)
            {
            displaycost.setText("Car Type:"+cartype+"\n"+"Car Model:"+carmodel+"\n"+"Number of Days:"+days+"\n"+"Total Cost: $"+totalcost);
            }
            @Override
            public void onClick(View v) {
                final RadioButton sedan=(RadioButton)findViewById(R.id.sedan);
                final RadioButton suv =(RadioButton) findViewById(R.id.suv);
                final RadioButton minivan=(RadioButton) findViewById(R.id.minivan);
                final Spinner spinner=(Spinner)findViewById(R.id.carmodel);
                final EditText totaldays =(EditText) findViewById(R.id.days);
             if(!totaldays.getText().toString().equals(""))
             {
                 Double[] cartypecost={30.0, 40.0, 45.0};
                 String [] carmodelnames={"Chevrolet", "Chrysler", "Dodge", "Ford" , "GMC", "Honda", "Hyundai", "Kia", "Mazda", "Nissan", "Toyota", "Volkswagen"};
                 int days=Integer.parseInt(totaldays.getText().toString());
                 double totalcost;
                 if(days > 30)
                 {
                     Toast.makeText(MainActivity.this, "You cannot rent a car more than 30 days", Toast.LENGTH_LONG).show();
                 }
                 else
                 {
                     if(sedan.isChecked())
                     {
                         totalcost=days * cartypecost[0];
                         displaycost(totalcost,"sedan",carmodelnames[spinner.getSelectedItemPosition()],days);
                     }
                     if(suv.isChecked())
                     {
                         totalcost=days * cartypecost[1];
                         displaycost(totalcost,"suv",carmodelnames[spinner.getSelectedItemPosition()],days);
                     }
                     if(minivan.isChecked())
                     {
                         totalcost=days * cartypecost[2];
                         displaycost(totalcost,"minivan",carmodelnames[spinner.getSelectedItemPosition()],days);

                     }
                 }
             }
             else
             {
                 Toast.makeText(MainActivity.this, "Please Enter Number of days", Toast.LENGTH_LONG).show();
             }
            }
        });
    }
}
