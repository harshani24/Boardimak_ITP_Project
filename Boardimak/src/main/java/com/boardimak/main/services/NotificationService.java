package com.boardimak.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.boardimak.main.model.Ticket;

@Service
public class NotificationService {

	private JavaMailSender javaMailSender;
	
	@Autowired
	public NotificationService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	public void sendNotification(Ticket ticket)throws MailException {
		
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo("sasika19951109@gmail.com");
		mail.setFrom(ticket.getEmail());
		mail.setSubject("Ticket");
		mail.setText("This is notification about created Ticket");
		
		javaMailSender.send(mail);
	}
}
