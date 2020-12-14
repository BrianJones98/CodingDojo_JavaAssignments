package com.brian.dojoninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brian.dojoninjas.models.Ninja;
import com.brian.dojoninjas.repositories.NinjaRepo;

@Service
public class NinjaService {
	
	@Autowired
	private NinjaRepo ninjaRepo;
	
	public List<Ninja> findAll(){
		return ninjaRepo.findAll();
	}
	
	public Ninja findById(Long id) {
		Optional<Ninja> ninja = ninjaRepo.findById(id);
		if(ninja.isPresent()) {
			return ninja.get();
		} else {
			return null;
		}
	}
	
	public Ninja save(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	
	public void delete(Long id) {
		ninjaRepo.deleteById(id);
	}
}
