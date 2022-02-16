package com.boardimak.main.model;
import java.util.Date;


import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="ticket")
public class Ticket {
	
	@Id
	@Column(name="ticket_id")
	private int id;
	private String name;
	private String email;
	private String status;
	private String subject;
	private String content;
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_date")
	private Date created_date;
	
	public Ticket() {
		
	}

	public Ticket(String name, String email, String status, String subject, String content,Date created_date) {
		super();
		this.name = name;
		this.email = email;
		this.status = status;
		this.subject = subject;
		this.content = content;
		this.created_date=created_date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", name=" + name + ", email=" + email + ", status=" + status + ", subject="
				+ subject + ", content=" + content + ", created_date=" + created_date + "]";
	}




	
	
	
	
	

}
