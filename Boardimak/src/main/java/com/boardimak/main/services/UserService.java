package com.boardimak.main.services;


import java.util.ArrayList;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boardimak.main.model.User;
import com.boardimak.main.repository.UsersRepository;


@Service
public class UserService {

	@Autowired
	private UsersRepository usersRepository;
	
	//View user
	public List<User> findAllUsers() {
		List<User> users = new ArrayList<User>();
		
		for(User user :usersRepository.findAll()) {
			users.add(user);
		}
		return users;
	}

	//Find user users when editing
	public User findOne(int id) {
		return usersRepository.findAllById(id);
	}
	
	//Save user
	public void saveUser(User user) {
		usersRepository.save(user);
	}
	
	//Delete user
	public void deleteUser(int id) {
		usersRepository.deleteById(id);
	}
	
	//Find by email
	public User findByEmail(String email) {
		return usersRepository.findByEmail(email);
	}
	
	//Find by email and password
	public void findByEmailAndPassword(String email, String password) {
		usersRepository.findByEmailAndPassword(email, password);
	}
}
