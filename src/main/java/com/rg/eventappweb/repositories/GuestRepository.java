package com.rg.eventappweb.repositories;

import com.rg.eventappweb.models.Guest;

public interface GuestRepository {
    public void save(Guest guest);
    public Guest findById(String id);
}
