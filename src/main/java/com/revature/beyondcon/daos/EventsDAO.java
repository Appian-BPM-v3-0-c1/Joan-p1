package com.revature.beyondcon.daos;

import com.revature.beyondcon.connection.DatabaseConnection;
import com.revature.beyondcon.models.Events;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        return null;
    }

    @Override
    public boolean update(Events updatedObj) {
        return false;
    }

    @Override
    public boolean removeById(String id) {
        return false;
    }

    public List<Events> findByConId(int id) {
        List<Events> eventList = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM events WHERE con_id = ?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Events events = new Events();

                events.setId(rs.getInt("id"));
                events.setTitle(rs.getString("title"));
                events.setEventDesc(rs.getString("event_desc"));
                events.setStartDate(rs.getString("start_date"));
                events.setStartTime(rs.getString("start_time"));
                events.setConId(rs.getInt("con_id"));

                eventList.add(events);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return eventList;
    }

}
