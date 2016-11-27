package com.example.jay.simplelist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jay on 9/24/16.
 */

public class CustomListAdapter extends BaseAdapter {
    private ArrayList<RowItem> listData;
    private LayoutInflater layoutInflater;

    private class ViewHolder {
        ImageView image;
        TextView carModelString;
    }

    public CustomListAdapter(Context context,
                             ArrayList<RowItem> listData) {
        this.listData = listData;
        layoutInflater = LayoutInflater.from(context);


    }
    public int getCount() {
        return listData.size();
    }

    public Object getItem(int position) {
        return listData.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_row_layout, null);
            holder = new ViewHolder();
            holder.image = (ImageView) convertView.findViewById(R.id.Image);
            holder.carModelString = (TextView) convertView.findViewById(R.id.carModelString);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.image.setImageResource(listData.get(position).getImageId());
        holder.carModelString.setText(listData.get(position).getCarModelString());

        return convertView;
    }

}