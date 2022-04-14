package com.revature.beyondcon.services;

import com.revature.beyondcon.daos.EventsDAO;

public class EventsService {
    private final EventsDAO eventsDAO;

    public EventsService(EventsDAO eventsDAO) {
        this.eventsDAO = eventsDAO;
    }

    public EventsDAO getEventsDAO() {
        return eventsDAO;
    }

}
