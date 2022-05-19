package com.revature.beyondcon.daos;

import com.revature.beyondcon.connection.DatabaseConnection;
import com.revature.beyondcon.models.Attendee;
import com.revature.beyondcon.models.ContactInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ContactInfoDAO implements CrudDAO<ContactInfo> {

    Connection con = DatabaseConnection.getCon();

    @Override
    public int save(ContactInfo obj) {
        int n = 0;

        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO contact_info (attendee_id, name_prefix, first_name, middle_name, last_name, name_suffix, email, sm_address, city, state, zip, telephone) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1, obj.getAttendeeId());
            ps.setString(2, obj.getNamePrefix());
            ps.setString(3, obj.getFirstName());
            ps.setString(4, obj.getMiddleName());
            ps.setString(5, obj.getLastName());
            ps.setString(6, obj.getNameSuffix());
            ps.setString(7, obj.getEmail());
            ps.setString(8, obj.getSmAddress());
            ps.setString(9, obj.getCity());
            ps.setString(10, obj.getState());
            ps.setString(11, obj.getZip());
            ps.setString(12, obj.getTelephone());

            n = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return n;
    }

    @Override
    public List<ContactInfo> findAll() {
        return null;
    }

    @Override
    public ContactInfo findById (int id) {
        return null;
    }

    public ContactInfo getByAttendeeId(int attendeeId) {
        ContactInfo contact = new ContactInfo();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM contact_info WHERE attendee_id = ?");
            ps.setInt(1, attendeeId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                contact.setId(rs.getInt("id"));
                contact.setAttendeeId(rs.getInt("attendee_id"));
                contact.setNamePrefix(rs.getString("name_prefix"));
                contact.setFirstName(rs.getString("first_name"));
                contact.setMiddleName(rs.getString("middle_name"));
                contact.setLastName(rs.getString("last_name"));
                contact.setNameSuffix(rs.getString("name_suffix"));
                contact.setEmail(rs.getString("email"));
                contact.setSmAddress(rs.getString("sm_address"));
                contact.setCity(rs.getString("city"));
                contact.setState(rs.getString("state"));
                contact.setZip(rs.getString("zip"));
                contact.setTelephone(rs.getString("telephone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return contact;
    }

    @Override
    public boolean update(ContactInfo updatedObj) {
        return false;
    }

    @Override
    public boolean removeById(String id) {
        return false;
    }

}