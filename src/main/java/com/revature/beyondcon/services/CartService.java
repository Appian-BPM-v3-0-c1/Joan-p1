package com.revature.beyondcon.services;

import com.revature.beyondcon.daos.AttendeeDAO;
import com.revature.beyondcon.daos.CartDAO;
import com.revature.beyondcon.daos.ConsDAO;
import com.revature.beyondcon.daos.ContactInfoDAO;

public class CartService {
    private final CartDAO cartDAO;
    private final ConsDAO consDAO;
    private final ContactInfoDAO contactInfoDAO;
    private final AttendeeDAO attendeeDAO;

    public CartService(CartDAO cartDAO, ConsDAO consDAO, ContactInfoDAO contactInfoDAO, AttendeeDAO attendeeDAO) {
        this.cartDAO = cartDAO;
        this.consDAO = consDAO;
        this.contactInfoDAO = contactInfoDAO;
        this.attendeeDAO = attendeeDAO;
    }

    public CartDAO getCartDAO() {
        return cartDAO;
    }

    public ConsDAO getConsDAO() {
        return consDAO;
    }

    public ContactInfoDAO getContactInfoDAO() {
        return contactInfoDAO;
    }

    public AttendeeDAO getAttendeeDAO() {
        return attendeeDAO;
    }

}
