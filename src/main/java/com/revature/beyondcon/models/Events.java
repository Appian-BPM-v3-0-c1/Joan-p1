package com.revature.beyondcon.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Events {
    private int id;
    private String title;
    private String eventDesc;
    private String startDate;
    private String startTime;
    private int conId;

    public Events() {
    }

    public Events(int id, String title, String eventDesc, String startDate, String startTime, int conId) {
        this.id = id;
        this.title = title;
        this.eventDesc = eventDesc;
        this.startDate = startDate;
        this.startTime = startTime;
        this.conId = conId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEventDesc() {
        return eventDesc;
    }

    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public int getConId() {
        return conId;
    }

    public void setConId(int conId) {
        this.conId = conId;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat nsdf = new SimpleDateFormat("MMM d, YYYY");
        SimpleDateFormat tsdf = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat ntsdf = new SimpleDateFormat("h:mm a");
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        try {
            c1.setTime(sdf.parse(startDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            c2.setTime(tsdf.parse(startTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String nStartDate = nsdf.format(c1.getTime());
        String nStartTime = ntsdf.format(c2.getTime());

        String[] ntitle = title.split(" ");
        for (int i = 0; i < ntitle.length; i++) {
            ntitle[i] = ntitle[i].substring(0, 1).toUpperCase() + ntitle[i].substring(1);
        }
        String jtitle = String.join(" ", ntitle);

        return "\nEvent: " + jtitle + "\nDescription: " + eventDesc + "\nDate: " + nStartDate + "\nTime: " + nStartTime;
    }

}
