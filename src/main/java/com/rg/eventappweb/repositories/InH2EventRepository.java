package com.rg.eventappweb.repositories;


import com.rg.eventappweb.models.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("InH2")
public class  InH2EventRepository implements EventRepository {

	@Autowired
	private JpaEventRepository jpaEventRepository;

	@Override
	public void save(Event event) {
		jpaEventRepository.save(event);
	}

	@Override
	public List<Event> findAll() {
		return jpaEventRepository.findAll();
	}
}
