package com.revature.beyondcon.models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Cities {
    private int id;
    private String city;
    private String state;
    private String date;

    public Cities() {
    }

    public Cities(int id, String city, String state, String date) {
        this.id = id;
        this.city = city;
        this.state = state;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Id: " + id + "\nCity: " + city + "\nState: " + state + "\nDate: " + date;
    }

}