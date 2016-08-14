package com.dpointgroup.myspanishhome.myspanishhomemobileapp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.dpointgroup.myspanishhome.myspanishhomemobileapp.App.AppController;

import java.util.List;

/**
 * Created by ekinmac on 08/08/16.
 */
public class RoomAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater li;
    private List<Room> roomItems;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public RoomAdapter(Activity activity, List<Room> roomItems) {
        this.activity = activity;
        this.roomItems = roomItems;
    }

    @Override
    public int getCount() {
        return roomItems.size();
    }

    @Override
    public Object getItem(int location) {
        return roomItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if (li == null){
            li = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (view == null){
            view = li.inflate(R.layout.custom_row, null);
        }
        if (imageLoader == null){
            imageLoader = AppController.getInstance().getImageLoader();
        }

        NetworkImageView thumbNail = (NetworkImageView) view.findViewById(R.id.thumbnail);
        //ImageView ivPhoto = (ImageView) view.findViewById(R.id.imageView);
        TextView tvTitle = (TextView) view.findViewById(R.id.txtTitle);
        TextView tvPrice = (TextView) view.findViewById(R.id.txtPrice);
        RatingBar rbRating = (RatingBar) view.findViewById(R.id.rbMovie);
        ProgressBar pbImage = (ProgressBar) view.findViewById(R.id.progressBar);

        tvTitle.setText(roomItems.get(position).getTitle());
        tvPrice.setText(roomItems.get(position).getTitle());
        rbRating.setRating(roomItems.get(position).getRating());

        //Getting room data for the row
        Room r = roomItems.get(position);

        //Thumbnail
        thumbNail.setImageUrl(r.getThumbnailURL(), imageLoader);
        pbImage.setVisibility(View.GONE);

        //Title
        tvTitle.setText(r.getTitle());

        //Price
        tvPrice.setText("€"+(Float.toString(r.getPrice())));

        //Rating
        rbRating.setRating(r.getRating());
        return view;
    }
}
