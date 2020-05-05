package com.rg.eventappweb.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


public class Event {
    private String id;
    private String title;

//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
//    private Date startDate;
//
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
//    private Date endDate;

    private List<Guest> guests = new ArrayList<>();

    public Event() {
        this.id = UUID.randomUUID().toString();
        System.out.println("event id: " + this.id);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public java.util.Date getStartDate() {
//        return startDate;
//    }
//
//    public void setStartDate(Date startDate) {
//        this.startDate = startDate;
//    }
//
//    public java.util.Date getEndDate() {
//        return endDate;
//    }
//
//    public void setEndDate(Date endDate) {
//        this.endDate = endDate;
//    }


    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", guests=" + guests +
                '}';
    }

    public void addGuest(Guest guest) {
        guests.add(guest);
    }
}
