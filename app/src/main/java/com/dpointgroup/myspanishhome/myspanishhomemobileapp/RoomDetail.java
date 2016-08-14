package com.dpointgroup.myspanishhome.myspanishhomemobileapp;

import java.util.List;

/**
 * Created by ekinmac on 14/08/16.
 */
public class RoomDetail extends Room {
    private String description;
    private List<Image> imageList;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
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
