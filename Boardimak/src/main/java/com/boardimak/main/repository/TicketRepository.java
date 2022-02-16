package com.boardimak.main.repository;

import org.springframework.data.repository.CrudRepository;
import com.boardimak.main.model.Ticket;

public interface TicketRepository extends CrudRepository<Ticket, Integer> {

	Ticket findAllById(int id);
	
	public Ticket findByname(String name);

	



}
