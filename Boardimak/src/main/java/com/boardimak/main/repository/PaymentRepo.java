package com.boardimak.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.boardimak.main.model.Payments;

public interface PaymentRepo extends CrudRepository<Payments, Integer>{

	@Query("SELECT p FROM Payments p WHERE p.stripe_id = ?1")
	List<Payments> getAllByStripeId(String stripeId);
	
	@Query("SELECT p FROM Payments p WHERE p.account_id = ?1")
	List<Payments> getAllByAccountId(String accountId);
}
