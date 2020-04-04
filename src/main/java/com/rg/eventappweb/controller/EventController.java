package com.rg.eventappweb.controller;

import com.rg.eventappweb.models.Event;
import com.rg.eventappweb.models.Guest;
import com.rg.eventappweb.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping(value = "/events")
    public List<Event> getEvents() {
        return eventService.getAll();
    }

    @PostMapping(value = "/event")
    public void create(@RequestBody Event event) {
        eventService.add(event);
    }


    @PostMapping(value = "/event/{id}/guest")
    public ResponseEntity<String> addGuest(@PathVariable String id, @RequestBody Guest guest) {

        eventService.addGuest(id, guest);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }
}