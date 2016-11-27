package com.example.jay.carshowroom;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList <String> cars=new ArrayList<String>();
    ArrayList <String> carNames=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        File f = new 	File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES).toString());





           File[] files=f.listFiles();


        for(int i=0;i<files.length;i++)
        {


            if(files[i].getName().endsWith(".jpg"))
            {
                cars.add(files[i].getAbsolutePath());
                carNames.add(files[i].getName());

            }
        }


      GridView grid = (GridView)findViewById(R.id.grid);
        grid.setAdapter(new ImageAdapter(this));

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener()  {
            @Override
            public void onItemClick(AdapterView<?> parent,
                                    View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(),
                        CarRent.class);
                i.putStringArrayListExtra("image_path_array", cars);
                i.putExtra("selected_index", position);
                i.putExtra("carNames",carNames);
                startActivity(i);
            }
        });

    }


    public class ImageAdapter extends BaseAdapter {
        private Context mContext;
        private int columWidth;
        private int columPadding = 10;

        public ImageAdapter(Context c) {
            mContext = c;
            Display display = getWindowManager().getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            final float scale = c.getResources().getDisplayMetrics().density;
            int padding = (int) (columPadding * scale + 0.5f);
            columWidth = size.x/3 - padding;
        }
        @Override
        public int getCount() {   return cars.size();    }
        public Object getItem(int position) {     return null;    }
        public long getItemId(int position) {    return 0;   }

        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(mContext);
            Bitmap bm= BitmapFactory.decodeFile(cars.get(position));
            imageView.setImageBitmap(bm);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setLayoutParams(new GridView.LayoutParams(columWidth,
                    columWidth));
            return imageView;
        }
    }

}
