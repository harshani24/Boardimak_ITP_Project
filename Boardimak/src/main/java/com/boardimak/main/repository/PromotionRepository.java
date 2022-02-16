package com.boardimak.main.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.boardimak.main.model.Promotion;


public interface PromotionRepository extends CrudRepository<Promotion, Integer>{

	Promotion findAllById(int id);
	
	//public Promotion findByUsernameAndPassword(String username,String password);
	
	//public Promotion findByStatus(String status);
	
	public List<Promotion> findAllByUser(int user);
	 
}




