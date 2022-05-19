package com.revature.beyondcon.daos;

import com.revature.beyondcon.connection.DatabaseConnection;
import com.revature.beyondcon.models.Tickets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TicketsDAO implements CrudDAO<Tickets> {

    Connection con = DatabaseConnection.getCon();

    @Override
    public int save(Tickets obj) {
        return 0;
    }

    @Override
    public List<Tickets> findAll() {
        return null;
    }

    @Override
    public Tickets findById(int id) {
        Tickets ticket = new Tickets();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM tickets WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ticket.setId(rs.getInt("id"));
                ticket.setTicketType(rs.getString("ticket_type"));
                ticket.setPrice(rs.getDouble("price"));
                ticket.setTotalTickets(rs.getInt("total_tickets"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ticket;
    }

    public int subtractTicket(int id) {
        int n = 0;

        try {
            PreparedStatement pstmt = con.prepareStatement("UPDATE tickets SET total_tickets = total_tickets - 1 WHERE id = ?");
            pstmt.setInt(1, id);

           n = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return n;
    }

    @Override
    public boolean update(Tickets updatedObj) {
        return false;
    }

    @Override
    public boolean removeById(String id) {
        return false;
    }

}
