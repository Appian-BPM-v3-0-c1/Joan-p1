package com.revature.beyondcon.daos;

import java.util.List;

public interface CrudDAO <T> {

    int save(T obj);

    List<T> findAll();

    T findById(String id);

    boolean update(T updatedObj);

    boolean removeById(String id);

}
