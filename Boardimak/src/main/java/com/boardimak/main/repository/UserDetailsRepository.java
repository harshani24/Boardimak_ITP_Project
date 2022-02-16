package com.boardimak.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boardimak.main.model.User;

public interface UserDetailsRepository extends JpaRepository<User, Integer> {
	
	User findByUserName(String username);

}
