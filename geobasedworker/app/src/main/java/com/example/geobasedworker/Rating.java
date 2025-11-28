package com.example.geobasedworker;

public class Rating {

    String name,type,hour,rating;

    public Rating() {
    }

    public Rating(String name, String type, String hour, String rating) {
        this.name = name;
        this.type = type;
        this.hour = hour;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
