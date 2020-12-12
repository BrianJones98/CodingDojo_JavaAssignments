package com.brian.license.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brian.license.models.License;
import com.brian.license.repositories.LicenseRepo;

@Service
public class LicenseService {
	
	@Autowired
	private LicenseRepo LicenseRepo;
	
	//Find all
	public List<License> allPeople(){
		return LicenseRepo.findAll();
	}
	
	//Find by ID
	public License findById(Long id) {
		Optional<License> License = LicenseRepo.findById(id);
		
		if(License.isPresent()) {
			return License.get();
		} else {
			return null;
		}
	}
	
	//Save (create or update)
	public License save(License License) {
		return LicenseRepo.save(License);
	}
	
	//Delete
	public void delete(Long id) {
		LicenseRepo.deleteById(id);
	}
}