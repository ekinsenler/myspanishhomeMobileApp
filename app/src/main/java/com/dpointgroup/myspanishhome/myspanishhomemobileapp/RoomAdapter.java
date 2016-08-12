package com.dpointgroup.myspanishhome.myspanishhomemobileapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ekinmac on 08/08/16.
 */
public class RoomAdapter extends ArrayAdapter {
    private List<Room> roomList;
    private int resource;
    private LayoutInflater inflater;
    public RoomAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
        roomList = objects;
        this.resource = resource;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = inflater.inflate(R.layout.custom_row, null);
        }

        ImageView ivPhoto = (ImageView) convertView.findViewById(R.id.imageView);
        TextView tvTitle = (TextView) convertView.findViewById(R.id.txtTitle);
        TextView tvPrice = (TextView) convertView.findViewById(R.id.txtPrice);
        RatingBar rbRating = (RatingBar) convertView.findViewById(R.id.rbMovie);

        tvTitle.setText(roomList.get(position).getTitle());
        tvPrice.setText(roomList.get(position).getTitle());
        rbRating.setRating(roomList.get(position).getRating());
        return convertView;
    }
}
