package com.revature.beyondcon.services;

import com.revature.beyondcon.daos.TicketsDAO;

public class TicketsService {

    private final TicketsDAO ticketsDAO;

    public TicketsService(TicketsDAO ticketsDAO) {
        this.ticketsDAO = ticketsDAO;
    }

    public TicketsDAO getTicketsDAO() {
        return ticketsDAO;
    }

}
