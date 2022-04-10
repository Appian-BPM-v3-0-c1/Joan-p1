package com.revature.beyondcon.daos;

import com.revature.beyondcon.connection.DatabaseConnection;
import com.revature.beyondcon.models.Cons;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ConsDAO implements CrudDAO<Cons> {

    Connection con = DatabaseConnection.getCon();

    @Override
    public int save(Cons obj) {
        int n = 0;

        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO cons (city, state, start_date) VALUES (?, ?, ?::date)");
            ps.setString(1, obj.getCity());
            ps.setString(2, obj.getState());
            ps.setString(3, obj.getDate());

            n = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return n;
    }

    @Override
    public List<Cons> findAll() {
        return null;
    }

    @Override
    public Cons findById(String id) {
        return null;
    }

    @Override
    public boolean update(Cons updatedObj) {
        return false;
    }

    @Override
    public boolean removeById(String id) {
        return false;
    }

}
