package com.rg.eventappweb.repositories;


import com.rg.eventappweb.models.Event;
import com.rg.eventappweb.models.Guest;

import java.util.List;

public interface EventRepository {
	public void save(Event event);
	public void update(Event event);

	public List<Event> findAll();

	public Event findById(String id);

	public void addGuest(String eventId, String guestId);


}
