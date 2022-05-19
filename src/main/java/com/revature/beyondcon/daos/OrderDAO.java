package com.revature.beyondcon.daos;

import com.revature.beyondcon.connection.DatabaseConnection;
import com.revature.beyondcon.models.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO implements CrudDAO<Order> {

    Connection con = DatabaseConnection.getCon();

    @Override
    public int save(Order obj) {
        int n = 0;

        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO order_history (transaction_date, transaction_time, attendee_id, ticket_id) VALUES (?::date, ?::time, ?, ?)");
            ps.setString(1, obj.getTransDate());
            ps.setString(2, obj.getTransTime());
            ps.setInt(3, obj.getAttendeeId());
            ps.setInt(4, obj.getTicketId());

            n = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return n;
    }

    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public Order findById(int id) {
        return null;
    }

    public List<Order> findByAttendeeId(int attendeeId) {
        List<Order> orders = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM order_history WHERE attendee_id = ?");
            ps.setInt(1, attendeeId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Order order = new Order();

                order.setId(rs.getInt("id"));
                order.setTransDate(rs.getString("transaction_date"));
                order.setTransTime(rs.getString("transaction_time"));
                order.setAttendeeId(rs.getInt("attendee_id"));
                order.setTicketId(rs.getInt("ticket_id"));

                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
    }

    @Override
    public boolean update(Order updatedObj) {
        return false;
    }

    @Override
    public boolean removeById(String id) {
        return false;
    }
}
