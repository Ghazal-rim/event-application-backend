package com.rg.eventappweb.controller;

import com.rg.eventappweb.models.Event;
import com.rg.eventappweb.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    public void create(@RequestBody Event event){
        eventService.add(event);
    }
}