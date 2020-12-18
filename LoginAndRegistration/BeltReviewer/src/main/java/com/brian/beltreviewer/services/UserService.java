package com.brian.beltreviewer.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brian.beltreviewer.models.Event;
import com.brian.beltreviewer.models.User;
import com.brian.beltreviewer.repositories.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo userRepo;
	
	public User registerUser(User user) {
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		
		return userRepo.save(user);
	}
	public User findByEmail(String email) {
		return userRepo.findByEmail(email);
	}
	public User findById(Long id) {
		Optional<User> user = userRepo.findById(id);
		
		if(user.isPresent()) {
			return user.get();
		} else {
			return null;
		}
	}
	public User joinEvent(Event event, User user) {
		if(user.getJoinedEvents().contains(event)) {
			return userRepo.save(user);
		} else {
			user.getJoinedEvents().add(event);
			return userRepo.save(user);
		}
	}
	public User unjoinEvent(Event event, User user) {
		if(!user.getJoinedEvents().contains(event)) {
			return userRepo.save(user);
		} else {
			user.getJoinedEvents().remove(event);
			return userRepo.save(user);
		}
	}
	public boolean authenticateUser(String email, String password) {
		User user = userRepo.findByEmail(email);
		
		if(user == null) {
			return false;
		} else {
			if(BCrypt.checkpw(password, user.getPassword())) {
				return true;
			} else {
				return false;
			}
		}
	}
}
