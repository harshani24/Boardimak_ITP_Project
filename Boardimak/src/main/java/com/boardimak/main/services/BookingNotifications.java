package com.boardimak.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.boardimak.main.model.Bookings;


@Service
public class BookingNotifications {

	
private JavaMailSender javaMailSender;
	
	@Autowired
	public BookingNotifications(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	public void sendNotificationsToUser(Bookings bookings)throws MailException {
		
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(bookings.getUser_email());
		mail.setFrom("aruniprashani@gmail.com");
		mail.setSubject("Booking");
		mail.setText("This is notification about bookings in bordimak. ");
		
		
		javaMailSender.send(mail);
	}
	
public void sendNotificationsToOwner(Bookings bookings)throws MailException {
		
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(bookings.getOwner_email());
		mail.setFrom("aruniprashani@gmail.com");
		mail.setSubject("Booked Your Property");
		mail.setText("This is notification about bookings in bordimak.Your property was booked ");
		
		
		javaMailSender.send(mail);
	}
public void sendNotificationsToUserStatus(Bookings bookings)throws MailException {
	
	SimpleMailMessage mail = new SimpleMailMessage();
	mail.setTo(bookings.getOwner_email());
	mail.setFrom("aruniprashani@gmail.com");
	mail.setSubject("Booking Status Changed");
	mail.setText("This is notification about bookings in bordimak.Your Booking was "+ bookings.getStatus() + "by the owner");
	
	
	javaMailSender.send(mail);
}


}
