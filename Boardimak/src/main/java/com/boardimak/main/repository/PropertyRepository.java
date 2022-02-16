package com.boardimak.main.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.boardimak.main.model.Property;


public interface PropertyRepository extends JpaRepository<Property, Integer> {
	
	Property findAllById(int id);

}
