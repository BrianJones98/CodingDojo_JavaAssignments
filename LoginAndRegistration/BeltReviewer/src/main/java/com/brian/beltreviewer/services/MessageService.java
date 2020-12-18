package com.brian.beltreviewer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brian.beltreviewer.models.Message;
import com.brian.beltreviewer.repositories.MessageRepo;

@Service
public class MessageService {
	@Autowired
	private MessageRepo messageRepo;
	
	public Message save(Message message) {
		return messageRepo.save(message);
	}
	public void delete(Long id) {
		messageRepo.deleteById(id);
	}
}
