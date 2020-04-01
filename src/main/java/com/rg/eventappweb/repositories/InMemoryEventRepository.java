package com.rg.eventappweb.repositories;


import com.rg.eventappweb.models.Event;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository("InMemory")
public class InMemoryEventRepository implements EventRepository {

	private List<Event> eventList = new ArrayList<>();

	@Override
	public void save(Event event) {

		eventList.add(event);

	}

	@Override
	public List<Event> findAll() {

		return eventList;

	}

}
