package com.revature.beyondcon.daos;

import com.revature.beyondcon.connection.DatabaseConnection;
import com.revature.beyondcon.models.Events;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EventsDAO implements CrudDAO<Events> {
    Connection con = DatabaseConnection.getCon();

    @Override
    public int save(Events obj) {
        return 0;
    }

    @Override
    public List<Events> findAll() {
        return null;
    }

    @Override
    public Events findById(int id) {
        Events events = new Events();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM events WHERE con_id = ?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                events.setId(rs.getInt("id"));
                events.setTitle(rs.getString("title"));
                events.setStartDate(rs.getString("start_date"));
                events.setStartTime(rs.getString("start_time"));
                events.setConId(rs.getInt("con_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return events;
    }

    @Override
    public boolean update(Events updatedObj) {
        return false;
    }

    @Override
    public boolean removeById(String id) {
        return false;
    }

}
