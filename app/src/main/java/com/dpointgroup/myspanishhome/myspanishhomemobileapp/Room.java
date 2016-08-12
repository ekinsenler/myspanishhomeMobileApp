package com.dpointgroup.myspanishhome.myspanishhomemobileapp;

import java.util.List;

/**
 * Created by ekinmac on 08/08/16.
 */
public class Room {
    private int room_id;
    private String title;
    private String description;
    private float price;
    private List<Image> images;
    private float rating;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public static class Image {
        private int image_id;
        private String URL;

        public int getImage_id() {
            return image_id;
        }

        public void setImage_id(int image_id) {
            this.image_id = image_id;
        }

        public String getURL() {
            return URL;
        }

        public void setURL(String URL) {
            this.URL = URL;
        }
    }
}
