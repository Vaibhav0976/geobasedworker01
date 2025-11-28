package com.example.geobasedworker;

public class Requirement {


    String name,number,address,require;


    public Requirement() {
    }

    public Requirement(String name, String number, String address, String require) {
        this.name = name;
        this.number = number;
        this.address = address;
        this.require = require;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRequire() {
        return require;
    }

    public void setRequire(String require) {
        this.require = require;
    }
}
