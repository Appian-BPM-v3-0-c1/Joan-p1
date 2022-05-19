package com.revature.beyondcon.models;

public class Tickets {
    
    private int id;
    private String ticketType;
    private Double price;
    private int totalTickets;

    public Tickets() {
    }

    public Tickets(int id, String ticketType, Double price, int totalTickets) {
        this.id = id;
        this.ticketType = ticketType;
        this.price = price;
        this.totalTickets = totalTickets;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    @Override
    public String toString() {
        return "Tickets{" +
                "id=" + id +
                ", ticketType='" + ticketType + '\'' +
                ", price='" + price + '\'' +
                ", totalTickets='" + totalTickets + '\'' +
                '}';
    }

}
