package com.revature.beyondcon.models;

public class Cart {
    private int id;
    private int ticketId;
    private int attendeeId;

    public Cart() {
    }

    public Cart(int id, int ticketId, int attendeeId) {
        this.id = id;
        this.ticketId = ticketId;
        this.attendeeId = attendeeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getAttendeeId() {
        return attendeeId;
    }

    public void setAttendeeId(int attendeeId) {
        this.attendeeId = attendeeId;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", ticketId=" + ticketId +
                ", attendeeId=" + attendeeId +
                '}';
    }

}
