package com.example.jay.pizzahut;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Spinner sp;
    RadioButton rd1;
    RadioButton rd2;
    EditText tf;
    TextView tv;
    Button b1;
    String[] topping={"Bacon","Chesse","Chicken","Mushroom","Pepperoni","Pineapple","Sausage"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp=(Spinner)findViewById(R.id.spinner);
        rd1=(RadioButton)findViewById(R.id.radioButton3);
        rd2=(RadioButton)findViewById(R.id.radioButton4);
        tf=(EditText) findViewById(R.id.editText);
        tv=(TextView)findViewById(R.id.textView3);
        b1=(Button) findViewById(R.id.button5);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int qty=Integer.parseInt(tf.getText().toString());
                String selectedtopping=topping[sp.getSelectedItemPosition()];
                if(rd1.isChecked())
                {
                    int pizzaPrice= qty * 12;
                    tv.setText("Your Order of "+qty+" Larger size with "+selectedtopping+ " topping has been placed. Please pay $"+pizzaPrice);
                }
                if(rd2.isChecked())
                {
                    int pizzaPrice= qty * 10;
                    tv.setText("Your Order of "+qty+" Larger size pizza with "+selectedtopping+ " topping has been placed. Please pay $"+pizzaPrice);
                }
            }
        });
    }
}
