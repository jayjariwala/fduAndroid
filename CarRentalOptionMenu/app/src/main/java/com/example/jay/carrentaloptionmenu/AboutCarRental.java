package com.example.jay.carrentaloptionmenu;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;

public class AboutCarRental extends Dialog {

    private Button close;

    public AboutCarRental(Context context)
    {
        super(context);
        setContentView(R.layout.activity_about_car_rental);
        close= (Button) findViewById(R.id.Button);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel();
            }
        });
    }

}
