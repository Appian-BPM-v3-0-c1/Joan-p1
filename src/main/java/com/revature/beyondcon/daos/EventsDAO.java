package com.revature.beyondcon.daos;

import com.revature.beyondcon.models.Events;

import java.util.List;

public class EventsDAO implements CrudDAO<Events> {

    @Override
    public int save(Events obj) {
        return 0;
    }

    @Override
    public List<Events> findAll() {
        return null;
    }

    @Override
    public Events findById(String id) {
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

}
