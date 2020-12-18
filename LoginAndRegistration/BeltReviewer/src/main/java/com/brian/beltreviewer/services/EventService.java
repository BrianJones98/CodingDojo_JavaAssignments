package com.brian.beltreviewer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brian.beltreviewer.models.Event;
import com.brian.beltreviewer.repositories.EventRepo;

@Service
public class EventService {
	@Autowired
	private EventRepo eventRepo;
	
	public List<Event> findByState(String state){
		return eventRepo.findByState(state);
	}
	public List<Event> findByStateNot(String state){
		return eventRepo.findByStateNot(state);
	}
	
	public Event findById(Long id) {
		Optional<Event> event = eventRepo.findById(id);
		
		if(event.isPresent()) {
			return event.get();
		} else {
			return null;
		}
	}
	public Event save(Event event) {
		return eventRepo.save(event);
	}
	public void delete(Long id) {
		eventRepo.deleteById(id);
	}
}
