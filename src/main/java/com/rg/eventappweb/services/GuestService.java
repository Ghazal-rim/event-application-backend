package com.rg.eventappweb.services;

import com.rg.eventappweb.models.Event;
import com.rg.eventappweb.models.Guest;
import com.rg.eventappweb.repositories.EventRepository;
import com.rg.eventappweb.repositories.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {



    @Autowired
    @Qualifier("GUEST_JDBC")
    private GuestRepository guestRepository;




    public List<Guest> getAllGuests()
    {
        return guestRepository.findAll();
    }



    public void addGuest(Guest guest) {
        guestRepository.save(guest);
    }


}
