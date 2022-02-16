package com.boardimak.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.boardimak.main.model.Users;

public interface UsersRepo extends JpaRepository<Users, Integer>{

	Users findAllByEmail(String email);
	
	@Query("SELECT u FROM Users u WHERE u.stripeId IS NOT NULL")
	List<Users> getUserByStripeNotNull();
	
	@Query("SELECT u FROM Users u WHERE u.stripeId = ?1")
	Users getUserByStripeId(String stripeId);
	
	@Query("SELECT u FROM Users u WHERE u.accountId = ?1")
	Users getUserByAccountId(String accountId);
}
