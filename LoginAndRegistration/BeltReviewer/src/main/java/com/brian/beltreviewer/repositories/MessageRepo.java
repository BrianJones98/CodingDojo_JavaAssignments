package com.brian.beltreviewer.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.brian.beltreviewer.models.Message;

@Repository
public interface MessageRepo extends CrudRepository<Message, Long>{

}
