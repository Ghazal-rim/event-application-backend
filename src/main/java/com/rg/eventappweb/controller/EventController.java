package com.rg.eventappweb.controller;

import com.rg.eventappweb.models.Event;
import com.rg.eventappweb.models.UserDetails;
import com.rg.eventappweb.services.EventService;
import com.rg.eventappweb.services.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private UserDetailsService userDetailsService;


    @GetMapping(value = "/events")
    public List<Event> getEvents() {
        return eventService.getAll();
    }

    @GetMapping(value = "/events/{id}")
    public ResponseEntity<Event> get(@PathVariable String id) {
        return ResponseEntity.ok().body(eventService.get(id));
    }

    // TODO IMPLEMENT SECURITY USING FILTER
    @PostMapping(value = "/events")
    public ResponseEntity<Event> create(@RequestBody Event event, HttpServletRequest request) {
        Event eventCreated = eventService.add(event);
        return ResponseEntity.status(HttpStatus.CREATED).body(eventCreated);
    }


    @PostMapping("/events/{eventId}/invite/{guestId}")
    public ResponseEntity<Event> invite(@PathVariable String eventId, @PathVariable String guestId, HttpServletRequest request) {

        Event event = eventService.invite(eventId, guestId);
        return ResponseEntity.ok(event);
    }
}