package com.example.anant.iitbhuvaranasi;

public class SingleVerticalData {

    private String club,title;
    private String date;
    private String image_club;
    private String image;
    private String viewcount,interested,notifid;

    public SingleVerticalData(){

    }



    public SingleVerticalData(String club, String title, String date, String image_club, String image, String viewcount, String interested, String notifid) {
        this.club = club;
        this.title = title;
        this.date = date;
        this.image_club = image_club;
        this.image = image;
        this.viewcount = viewcount;
        this.interested = interested;
        this.notifid=notifid;
    }
    public String getNotifid() {
        return notifid;
    }

    public void setNotifid(String notifid) {
        this.notifid = notifid;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImage_club() {
        return image_club;
    }

    public void setImage_club(String image_club) {
        this.image_club = image_club;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getViewcount() {
        return viewcount;
    }

    public void setViewcount(String viewcount) {
        this.viewcount = viewcount;
    }

    public String getInterested() {
        return interested;
    }

    public void setInterested(String interested) {
        this.interested = interested;
    }
}
