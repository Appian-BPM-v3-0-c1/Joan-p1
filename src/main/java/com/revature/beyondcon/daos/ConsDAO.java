package com.revature.beyondcon.daos;

import com.revature.beyondcon.connection.DatabaseConnection;
import com.revature.beyondcon.models.Cons;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        List<Cons> consList = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM cons");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cons cons = new Cons();

                cons.setId(rs.getInt("id"));
                cons.setCity(rs.getString("city"));
                cons.setState(rs.getString("state"));
                cons.setDate(rs.getString("start_date"));

                consList.add(cons);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return consList;
    }

    @Override
    public Cons findById (int id) {
        return null;
    }

    public List<Cons> findByCity(String city) {
        List<Cons> cons = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM cons WHERE city LIKE ?");
            ps.setString(1, "%" + city + "%");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cons con = new Cons();

                con.setId(rs.getInt("id"));
                con.setCity(rs.getString("city"));
                con.setState(rs.getString("state"));
                con.setDate(rs.getString("start_date"));

                cons.add(con);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cons;
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