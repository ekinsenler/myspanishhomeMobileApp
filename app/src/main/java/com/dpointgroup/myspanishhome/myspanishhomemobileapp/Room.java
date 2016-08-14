package com.dpointgroup.myspanishhome.myspanishhomemobileapp;

import java.util.List;

/**
 * Created by ekinmac on 08/08/16.
 */
public class Room {
    private int room_id;
    private String title;
    private float price;
    private float rating;
    private String thumbnailURL;

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
