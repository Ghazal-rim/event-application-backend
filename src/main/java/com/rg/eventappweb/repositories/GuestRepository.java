package com.rg.eventappweb.repositories;

import com.rg.eventappweb.models.Event;
import com.rg.eventappweb.models.Guest;

import java.util.List;

public interface GuestRepository {
    public void save(Guest guest);
    public Guest findById(String id);
    public List<Guest> findAll();
}
