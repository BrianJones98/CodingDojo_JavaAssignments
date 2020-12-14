package com.brian.dojoninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brian.dojoninjas.models.Dojo;
import com.brian.dojoninjas.repositories.DojoRepo;

@Service
public class DojoService {
	
	@Autowired
	private DojoRepo dojoRepo;
	
	public List<Dojo> findAll(){
		return dojoRepo.findAll();
	}
	
	public Dojo findById(Long id) {
		Optional<Dojo> dojo = dojoRepo.findById(id);
		if(dojo.isPresent()) {
			return dojo.get();
		} else {
			return null;
		}
	}
	
	public Dojo save(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	
	public void delete(Long id) {
		dojoRepo.deleteById(id);
	}
}
