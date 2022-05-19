package com.revature.beyondcon.daos;

import com.revature.beyondcon.connection.DatabaseConnection;
import com.revature.beyondcon.models.Attendee;
import com.revature.beyondcon.models.ContactInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttendeeDAO implements CrudDAO<Attendee> {

    Connection con = DatabaseConnection.getCon();

    @Override
    public int save(Attendee obj) {
        int n = 0;

        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO attendees (username, password, u_type) VALUES (?, ?, ?)");
            ps.setString(1, obj.getUsername());
            ps.setString(2, obj.getPassword());
            ps.setBoolean(3, obj.isuType());

            n = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return n;
    }

    @Override
    public List<Attendee> findAll() {
        List<Attendee> attendeeList = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM attendees");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Attendee attendee = new Attendee();

                attendee.setId(rs.getInt("id"));
                attendee.setUsername(rs.getString("username"));
                attendee.setPassword(rs.getString("password"));

                attendeeList.add(attendee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return attendeeList;
    }

    @Override
    public Attendee findById(int id) {
        return null;
    }

    @Override
    public boolean update(Attendee updatedObj) {
        return false;
    }

    @Override
    public boolean removeById(String id) {
        return false;
    }

    public List<String> findAllUsernames() {
        List<String> usernameList = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT (username) FROM attendees");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                usernameList.add(rs.getString("username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usernameList;
    }

    public Attendee getByUserName (String username) {
        Attendee attendee = new Attendee();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM attendees WHERE username = ?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                attendee.setId(rs.getInt("id"));
                attendee.setUsername(rs.getString("username"));
                attendee.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return attendee;
    }

}