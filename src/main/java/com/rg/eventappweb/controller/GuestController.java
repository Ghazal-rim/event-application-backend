package com.rg.eventappweb.controller;

import com.rg.eventappweb.models.Event;
import com.rg.eventappweb.models.Guest;
import com.rg.eventappweb.services.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;

@RestController
@RequestMapping("/guests")
public class GuestController {

    @Autowired
    private GuestService guestService;

    @PostMapping
    public ResponseEntity<Guest> create(@RequestBody Guest guest){
        guestService.addGuest(guest);
        return ResponseEntity.status(HttpStatus.CREATED).body(guest);
    }


}
