package com.example.anant.iitbhuvaranasi;

public class SingleVerticalData {

    private String header;
    private String date;
    private String council;
    private int image;



    private int event_image_club;

    public SingleVerticalData(){

    }

    public SingleVerticalData(String council,String header, String date, int image,int event_image_club) {
        this.header = header;
        this.council = council;
        this.date = date;
        this.image = image;
        this.event_image_club=event_image_club;
    }

    public String getCouncil() {
        return council;
    }

    public void setCouncil(String council) {
        this.council = council;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getEvent_image_club() {
        return event_image_club;
    }

    public void setEvent_image_club(int event_image_club) {
        this.event_image_club = event_image_club;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
