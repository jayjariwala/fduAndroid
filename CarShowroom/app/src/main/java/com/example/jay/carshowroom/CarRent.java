package com.example.jay.carshowroom;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CarRent extends AppCompatActivity {

    private ImageView image;
    private TextView carNameTextView,rentTextView;
    private String carnames[]= {"CCXR Trevita ","lamborghini Veneno"," Lykan Hypersport","Bugatti Veyron","Ferrari Pininfarina","Pagani Huayra BC"};
    private String carrent[]= {"$150/day","$140/day","$135/day","$130/day","$125/day","$120/day","$110/day"};

    private Bitmap bm;
    private ArrayList<String> imagePathArray,carNames;
    private int selectedIndex;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_rent);
        carNameTextView =(TextView) findViewById(R.id.carNameTextView);
        rentTextView=(TextView)findViewById(R.id.rentTextView);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            imagePathArray = extras.getStringArrayList("image_path_array");
            selectedIndex = extras.getInt("selected_index");
            carNames=extras.getStringArrayList("carNames");
            image = (ImageView)findViewById(R.id.imageView);
            bm= BitmapFactory.decodeFile(imagePathArray.get(selectedIndex));
            image.setImageBitmap(bm);
            image.setScaleType(ImageView.ScaleType.FIT_CENTER);
             if(carNames.get(selectedIndex).equals("car1.jpg"))
             {
                carNameTextView.setText(carnames[0].toString());
                 rentTextView.setText(carrent[0].toString());

             }
            if(carNames.get(selectedIndex).equals("car2.jpg"))
            {
                carNameTextView.setText(carnames[1]);
                rentTextView.setText(carrent[1]);
            }
            if(carNames.get(selectedIndex).equals("car3.jpg"))
            {
                carNameTextView.setText(carnames[2]);
                rentTextView.setText(carrent[2]);
            }
            if(carNames.get(selectedIndex).equals("car4.jpg"))
            {
                carNameTextView.setText(carnames[3]);
                rentTextView.setText(carrent[3]);
            }
            if(carNames.get(selectedIndex).equals("car5.jpg"))
            {
                carNameTextView.setText(carnames[4]);
                rentTextView.setText(carrent[4]);
            }
            if(carNames.get(selectedIndex).equals("car6.jpg"))
            {
                carNameTextView.setText(carnames[5]);
                rentTextView.setText(carrent[5]);
            }


    }

}

}
