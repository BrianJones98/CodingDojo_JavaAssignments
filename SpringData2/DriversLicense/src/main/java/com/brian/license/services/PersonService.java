package com.brian.license.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brian.license.models.Person;
import com.brian.license.repositories.PersonRepo;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepo personRepo;
	
	//Find all
	public List<Person> allPeople(){
		return personRepo.findAll();
	}
	
	//Find by ID
	public Person findById(Long id) {
		Optional<Person> person = personRepo.findById(id);
		
		if(person.isPresent()) {
			return person.get();
		} else {
			return null;
		}
	}
	
	//Save (create or update)
	public Person save(Person person) {
		return personRepo.save(person);
	}
	
	//Delete
	public void delete(Long id) {
		personRepo.deleteById(id);
	}
}
