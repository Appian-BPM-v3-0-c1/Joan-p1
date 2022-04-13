package com.revature.beyondcon.daos;

import com.revature.beyondcon.connection.DatabaseConnection;
import com.revature.beyondcon.models.Attendee;

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
            PreparedStatement ps = con.prepareStatement("INSERT INTO attendees (username, password) VALUES (?, ?)");
            ps.setString(1, obj.getUsername());
            ps.setString(2, obj.getPassword());

            n = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return n;
    }

    @Override
    public List<Attendee> findAll() {
        return null;
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

}
