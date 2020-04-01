package com.rg.eventappweb.repositories;

import com.rg.eventappweb.models.Event;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JpaEventRepository extends CrudRepository<Event, Long> {

    List<Event> findAll();
}
