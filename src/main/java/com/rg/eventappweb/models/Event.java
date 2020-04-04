package com.rg.eventappweb.models;

import com.rg.eventappweb.services.EventService;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Entity
public class Event {

	private String title;
	@Id
	private String id;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Guest> guests = new ArrayList<>();

	public Event(){
		this.id = UUID.randomUUID().toString();
	}
	public Event(String title) {
		this();
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public void setGuests(List<Guest> guests) {
		this.guests = guests;
	}

	public List<Guest> getGuests() {
		return guests;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Event{" +
				"title='" + title + '\'' +
				", id='" + id + '\'' +
				", guests=" + guests.size() +
				'}';
	}

	public void addGuest(Guest guest) {
		guests.add(guest);
	}
}
