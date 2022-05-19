package com.revature.beyondcon.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Cons {
    private int id;
    private String city;
    private String state;
    private String date;

    public Cons() {
    }

    public Cons(int id, String city, String state, String date) {
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
        String date2 = date;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat nsdf = new SimpleDateFormat("MMM d, YYYY");
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        try {
            c1.setTime(sdf.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            c2.setTime(sdf.parse(date2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c2.add(Calendar.DATE, 2);
        String ndate = nsdf.format(c1.getTime());
        String ndate2 = nsdf.format(c2.getTime());

        String[] ncity = city.split(" ");
        for (int i = 0; i < ncity.length; i++) {
            ncity[i] = ncity[i].substring(0, 1).toUpperCase() + ncity[i].substring(1);
        }
        String jcity = String.join(" ", ncity);

        String[] nstate = state.split(" ");
        for (int i = 0; i < nstate.length; i++) {
            nstate[i] = nstate[i].substring(0, 1).toUpperCase() + nstate[i].substring(1);
        }
        String jstate = String.join(" ", nstate);

        return "BeyondCon 2023\n" + jcity + ", " + jstate + "\nFrom " + ndate + " to " + ndate2;
    }

}