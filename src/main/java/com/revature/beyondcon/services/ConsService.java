package com.revature.beyondcon.services;

import com.revature.beyondcon.daos.ConsDAO;
import com.revature.beyondcon.daos.EventsDAO;

public class ConsService {
    private final ConsDAO consDAO;
    private final EventsDAO eventsDAO;

    public ConsService(ConsDAO consDAO, EventsDAO eventsDAO) {
        this.consDAO = consDAO;
        this.eventsDAO = eventsDAO;
    }

    public ConsDAO getConsDAO() {
        return consDAO;
    }

    public EventsDAO getEventsDAO() {
        return eventsDAO;
    }
}
