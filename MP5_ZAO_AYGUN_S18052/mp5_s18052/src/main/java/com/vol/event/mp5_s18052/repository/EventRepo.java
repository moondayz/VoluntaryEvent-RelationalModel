package com.vol.event.mp5_s18052.repository;

import org.springframework.data.repository.CrudRepository;

import com.vol.event.mp5_s18052.model.inheritance.Event;

public interface EventRepo extends CrudRepository<Event, Long> {

	
}
