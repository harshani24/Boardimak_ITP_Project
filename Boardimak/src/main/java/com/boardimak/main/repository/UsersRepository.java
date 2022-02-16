package com.boardimak.main.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.boardimak.main.model.User;

@Repository
public interface UsersRepository extends CrudRepository<User, Integer> {

	User findAllById(int id);
	
	User findByEmail(String email);
	
	User findByEmailAndPassword(String email, String password);
	
}
