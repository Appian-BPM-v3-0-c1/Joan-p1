package com.revature.beyondcon.services;

import com.revature.beyondcon.daos.CartDAO;
import com.revature.beyondcon.daos.ContactInfoDAO;
import com.revature.beyondcon.daos.OrderDAO;

public class OrderService {
    private final CartDAO cartDAO;
    private final ContactInfoDAO contactInfoDAO;
    private final OrderDAO orderDAO;

    public OrderService(CartDAO cartDAO, ContactInfoDAO contactInfoDAO, OrderDAO orderDAO) {
        this.cartDAO = cartDAO;
        this.contactInfoDAO = contactInfoDAO;
        this.orderDAO = orderDAO;
    }

    public CartDAO getCartDAO() {
        return cartDAO;
    }

    public ContactInfoDAO getContactInfoDAO() {
        return contactInfoDAO;
    }

    public OrderDAO getOrderDAO() {
        return orderDAO;
    }

}
