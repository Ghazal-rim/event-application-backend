package com.rg.eventappweb.repositories;


import com.rg.eventappweb.models.Event;

import java.util.List;

public interface EventRepository {
	public void save(Event event);

	public List<Event> findAll();
}
