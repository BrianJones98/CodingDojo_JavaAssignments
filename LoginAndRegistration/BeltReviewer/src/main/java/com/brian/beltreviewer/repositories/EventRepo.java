package com.brian.beltreviewer.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.brian.beltreviewer.models.Event;

@Repository
public interface EventRepo extends CrudRepository<Event, Long> {
	List<Event> findByState(String state);
	List<Event> findByStateNot(String state);
}
