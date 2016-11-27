package com.example.jay.songsalbum;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    Integer[] images={R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,R.drawable.img6};
    Integer[] songs={R.raw.song1,R.raw.song2,R.raw.song3,R.raw.song4,R.raw.song5,R.raw.song6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView grid=(GridView)findViewById(R.id.gridView);

        grid.setAdapter(new ImageAdapter(this));

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener()  {
            @Override
            public void onItemClick(AdapterView<?> parent,
                                    View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(),
                        AlbumActivity.class);

                i.putExtra("song", songs[position]);
                i.putExtra("cover",images[position]);

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
            Point size = new Point();        display.getSize(size);
            final float scale = c.getResources().getDisplayMetrics().density;
            int padding = (int) (columPadding * scale + 0.5f);
            columWidth = size.x/3 - padding;
        }
        @Override
        public int getCount() {   return images.length;    }
        public Object getItem(int position) {     return null;    }
        public long getItemId(int position) {    return 0;   }

        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(mContext);
            imageView.setImageResource(images[position]);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setLayoutParams(new GridView.LayoutParams(columWidth,
                    columWidth));
            return imageView;
        }
    }

}
