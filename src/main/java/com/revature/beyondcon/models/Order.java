package com.revature.beyondcon.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Order {
    private int id;
    private String transDate;
    private String transTime;
    private int attendeeId;
    private int ticketId;

    public Order() {
    }

    public Order(int id, String transDate, String transTime, int attendeeId, int ticketId) {
        this.id = id;
        this.transDate = transDate;
        this.transTime = transTime;
        this.attendeeId = attendeeId;
        this.ticketId = ticketId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTransDate() {
        return transDate;
    }

    public void setTransDate(String transDate) {
        this.transDate = transDate;
    }

    public String getTransTime() {
        return transTime;
    }

    public void setTransTime(String transTime) {
        this.transTime = transTime;
    }

    public int getAttendeeId() {
        return attendeeId;
    }

    public void setAttendeeId(int attendeeId) {
        this.attendeeId = attendeeId;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
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
            c1.setTime(sdf.parse(transDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            c2.setTime(tsdf.parse(transTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String nTransDate = nsdf.format(c1.getTime());
        String nTransTime = ntsdf.format(c2.getTime());

        return "\nTransaction Date: " + nTransDate + "\n" +
                "Transaction Time: " + nTransTime;
    }

}
