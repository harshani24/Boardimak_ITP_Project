package com.boardimak.main.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Proposal {

	@Id
	private int proposal_id;
	private String message_head;
	private String message_body;
	private int property_id;
	private int user_id;
	private String status;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public Proposal(){
		this.proposal_id =0;
		this.message_head = "";
		this.message_body = "";
	}
	public Proposal(String message_head, String message_body, int property_id, int user_id) {
		super();
		this.message_head = message_head;
		this.message_body = message_body;
		this.property_id = property_id;
		this.user_id = user_id;

	}
	public int getProposal_id() {
		return proposal_id;
	}
	public void setProposal_id(int proposal_id) {
		this.proposal_id = proposal_id;
	}
	public String getMessage_head() {
		return message_head;
	}
	public void setMessage_head(String message_head) {
		this.message_head = message_head;
	}
	public String getMessage_body() {
		return message_body;
	}
	public void setMessage_body(String message_body) {
		this.message_body = message_body;
	}
	public int getProperty_id() {
		return property_id;
	}
	public void setProperty_id(int property_id) {
		this.property_id = property_id;
	}
	
	
}
