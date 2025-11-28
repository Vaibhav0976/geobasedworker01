package com.example.geobasedworker;

public class Workers {

    String Name,Type,Mobileno,Address,Charges,hours,imageurl,lati,longi;

    int expe;



    public Workers() {
    }

    public Workers(String name, String type, String mobileno, String address, String charges, String hours, String imageurl, String lati, String longi, int expe) {
        Name = name;
        Type = type;
        Mobileno = mobileno;
        Address = address;
        Charges = charges;
        this.hours = hours;
        this.imageurl = imageurl;
        this.lati = lati;
        this.longi = longi;
        this.expe = expe;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getMobileno() {
        return Mobileno;
    }

    public void setMobileno(String mobileno) {
        Mobileno = mobileno;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCharges() {
        return Charges;
    }

    public void setCharges(String charges) {
        Charges = charges;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getLati() {
        return lati;
    }

    public void setLati(String lati) {
        this.lati = lati;
    }

    public String getLongi() {
        return longi;
    }

    public void setLongi(String longi) {
        this.longi = longi;
    }

    public int getExpe() {
        return expe;
    }

    public void setExpe(int expe) {
        this.expe = expe;
    }
}
