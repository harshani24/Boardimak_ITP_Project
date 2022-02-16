package com.boardimak.main.services;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

import com.boardimak.main.model.ReplyTicket;
import com.boardimak.main.model.Ticket;
import com.boardimak.main.repository.ReplyTicketRepository;

@Service
@Transactional
public class TicketReplyService {

	private ReplyTicketRepository replyticketrepository;
	
	public TicketReplyService(ReplyTicketRepository replyticketrepository) {
		this.replyticketrepository = replyticketrepository;
	}
	
	public void saveReplyTicket(ReplyTicket reply) {
		replyticketrepository.save(reply);
	}
	
	public List<ReplyTicket> ShowReply(){
		List<ReplyTicket> replys = new ArrayList<ReplyTicket>();
		for(ReplyTicket reply :replyticketrepository.findAll()) {
			replys.add(reply);
		}
		return replys;
	}
	
}
