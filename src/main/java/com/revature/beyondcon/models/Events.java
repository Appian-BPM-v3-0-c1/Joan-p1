package com.revature.beyondcon.models;

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

    public void setEventDesc(String title) {
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
        return "ID: " + id + "\nEvent Title: " + title + "\nDescription: " + eventDesc + "\nDate: " + startDate + "\nTime: " + startTime + "\nConvention ID: " + conId;
    }

}
