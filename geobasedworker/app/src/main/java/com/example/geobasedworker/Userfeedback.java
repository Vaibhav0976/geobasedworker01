package com.example.geobasedworker;

public class Userfeedback {


    public Userfeedback() {
    }

    String uname,number,feedback,rating,wname,wnumber,type,hour;

    public Userfeedback(String uname, String number, String feedback, String rating, String wname, String wnumber, String type, String hour) {
        this.uname = uname;
        this.number = number;
        this.feedback = feedback;
        this.rating = rating;
        this.wname = wname;
        this.wnumber = wnumber;
        this.type = type;
        this.hour = hour;
    }


    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getWname() {
        return wname;
    }

    public void setWname(String wname) {
        this.wname = wname;
    }

    public String getWnumber() {
        return wnumber;
    }

    public void setWnumber(String wnumber) {
        this.wnumber = wnumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }
}
