package com.rg.eventappweb.controller;

import com.rg.eventappweb.models.Event;
import com.rg.eventappweb.models.Guest;
import com.rg.eventappweb.models.User;
import com.rg.eventappweb.services.EventService;
import com.rg.eventappweb.services.GuestService;
import com.rg.eventappweb.services.UserService;
import org.apache.catalina.startup.Tomcat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class EventController {

    @Autowired
    private EventService eventService;
    private UserService userService;


    @GetMapping(value = "/events")
    public List<Event> getEvents() {
        return eventService.getAll();
    }

    @GetMapping(value = "/events/{id}")
    public ResponseEntity<Event> get(@PathVariable String id) {
        return ResponseEntity.ok().body(eventService.get(id));
    }

    @PostMapping(value = "/events")
    public ResponseEntity<Event> create(@RequestBody Event event) {
       Event eventCreated = eventService.add(event);
       return ResponseEntity.status(HttpStatus.CREATED).body(eventCreated);
    }

    @PostMapping("/events/{eventId}/invite/{guestId}")
    public ResponseEntity<Event> invite(@PathVariable String eventId, @PathVariable String guestId) {
       Event event = eventService.invite(eventId,guestId);
       return ResponseEntity.ok(event);
    }
    @GetMapping("/headers")
    public ResponseEntity<String> getHeader(@RequestHeader("profile") String profile) {
        // code that uses the User variable
        User user = userService.addUser(profile);
        return ResponseEntity.ok(profile);
    }


}