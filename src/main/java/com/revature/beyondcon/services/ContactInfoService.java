package com.revature.beyondcon.services;

import com.revature.beyondcon.daos.AttendeeDAO;
import com.revature.beyondcon.daos.ContactInfoDAO;

public class ContactInfoService {

    private final ContactInfoDAO contactInfoDAO;
    private final AttendeeDAO attendeeDAO;

    public ContactInfoService(ContactInfoDAO contactInfoDAO, AttendeeDAO attendeeDAO) {
        this.contactInfoDAO = contactInfoDAO;
        this.attendeeDAO = attendeeDAO;
    }

    public ContactInfoDAO getContactInfoDAO() {
        return contactInfoDAO;
    }

    public AttendeeDAO getAttendeeDAO() {
        return attendeeDAO;
    }

}
