package com.example.anant.iitbhuvaranasi;

public class CLubFeedData {

    private int image;
    private String title;

    public CLubFeedData(int image, String title) {
        this.image = image;
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
