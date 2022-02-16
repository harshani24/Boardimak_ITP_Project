package com.boardimak.main.services;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

import com.boardimak.main.model.ReplyTicket;
import com.boardimak.main.model.Ticket;
import com.boardimak.main.repository.TicketRepository;

@Service
@Transactional
public class TicketService {
	
	private final TicketRepository ticketRepository;
	
	public TicketService(TicketRepository ticketRepository) {
		this.ticketRepository = ticketRepository;
	}
	
	 public List<Ticket> findAll() {

	        return (List<Ticket>) ticketRepository.findAll();
	    }

	public void saveMyTicket(Ticket ticket) {
		
		ticketRepository.save(ticket);
	}
	
	public List<Ticket> ShowAllTickets(){
		List<Ticket> tickets = new ArrayList<Ticket>();
		for(Ticket ticket1 :ticketRepository.findAll()) {
			tickets.add(ticket1);
		}
		return tickets;
	}
	
	public void deleteMyTickets(int id) {
		ticketRepository.deleteById(id);
	}
	
	public Ticket editMyTicket(int id) {
	return ticketRepository.findAllById(id);
	
	}

	public Ticket findByname(String name) {
		return ticketRepository.findByname(name);
	}

	



}
