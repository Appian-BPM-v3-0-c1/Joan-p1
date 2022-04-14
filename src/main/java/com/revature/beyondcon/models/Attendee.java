package com.revature.beyondcon.models;

public class Attendee {

    private int id;
    private String username;
    private String password;
    private boolean uType;

    public Attendee() {
    }

    public Attendee(int id, String username, String password, boolean uType) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.uType = uType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getUType() {
        return uType;
    }

    public void setUType(boolean uType) {
        this.uType = uType;
    }

    @Override
    public String toString() {
        return "Username: " + username;
    }

}
