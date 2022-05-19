package com.revature.beyondcon.daos;

import com.revature.beyondcon.connection.DatabaseConnection;
import com.revature.beyondcon.models.Cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CartDAO implements CrudDAO<Cart> {

    Connection con = DatabaseConnection.getCon();

    @Override
    public int save(Cart obj) {
        int n = 0;

        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO cart (ticket_id, attendee_id) VALUES (?, ?)");
            ps.setInt(1, obj.getTicketId());
            ps.setInt(2, obj.getAttendeeId());

            n = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return n;
    }

    @Override
    public List<Cart> findAll() {
        return null;
    }

    @Override
    public Cart findById(int id) {
        return null;
    }

    public Cart findByAttendeeId(int attendeeId) {
        Cart cart = new Cart();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM cart WHERE attendee_id = ?");
            ps.setInt(1, attendeeId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                cart.setId(rs.getInt("id"));
                cart.setTicketId(rs.getInt("ticket_id"));
                cart.setAttendeeId(rs.getInt("attendee_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cart;
    }

    @Override
    public boolean update(Cart updatedObj) {
        return false;
    }

    public boolean removeById(String id) {
        return false;
    }

    public int deleteCart(Cart obj) {
        int n = 0;

        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM cart WHERE id = ?");
            ps.setInt(1, obj.getId());

            n = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return n;
    }

}
