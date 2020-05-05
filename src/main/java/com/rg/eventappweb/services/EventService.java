package com.rg.eventappweb.services;



import com.rg.eventappweb.models.Event;
import com.rg.eventappweb.models.Guest;
import com.rg.eventappweb.repositories.EventRepository;
import com.rg.eventappweb.repositories.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

	@Autowired
	@Qualifier("EVENT_JDBC")
	private EventRepository eventRepository;
	@Autowired
	@Qualifier("GUEST_JDBC")
	private GuestRepository guestRepository;

	public Event add(Event event) {
		try {
			eventRepository.save(event);
			return event;
		}catch(Exception e){
			throw new RuntimeException(e);
		}

    }

	public List<Event> getAll() {
		return eventRepository.findAll();

	}

	public void setEventRepository(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}

    public Event invite(String eventId, String guestId) {
		Event event = eventRepository.findById(eventId);
		Guest guest = guestRepository.findById(guestId);
		event.addGuest(guest);
		eventRepository.addGuest(eventId, guestId);
		return event;
	}


	public Event get(String id) {
		return eventRepository.findById(id);
	}
}
