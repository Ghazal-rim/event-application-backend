package com.rg.eventappweb.services;



import com.rg.eventappweb.models.Event;
import com.rg.eventappweb.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

	@Autowired
	@Qualifier("InH2")
	private EventRepository eventRepository;

	public void add(Event event) {
		eventRepository.save(event);
	}

	public List<Event> getAll() {
		return eventRepository.findAll();

	}

	public void setEventRepository(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}
	
	
}
