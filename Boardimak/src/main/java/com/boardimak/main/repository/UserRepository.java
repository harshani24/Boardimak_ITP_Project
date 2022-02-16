package com.boardimak.main.repository;


import org.springframework.data.repository.CrudRepository;

import com.boardimak.main.model.User;


public interface UserRepository extends CrudRepository<User, Integer>{

	User findAllById(int id);
	
}


