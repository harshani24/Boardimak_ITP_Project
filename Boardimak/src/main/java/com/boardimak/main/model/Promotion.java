package com.boardimak.main.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name="promotion")
public class Promotion {
        
	@Id
    @Column(name="promotion_id")
	private int id;
    private int property_id;
    @Column(name="user_id")
    private int user;
    private String pro_price;
    private String status;
	private String percentage;
	private String new_price;

	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="start_date")
	private Date start_date;
	
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="end_date")
	private Date end_date;
	
	

	public Promotion() {
		super();
		this.property_id = 0;
		this.user = 0;
		this.pro_price = "";
		this.status = "Active";
		this.percentage = "";
	    this.new_price = "";
		//this.start_date = ;
		//this.end_date = end_date;
	    
	 
	}
	
	
  public Promotion(int property_id, int user_id, String pro_price, String status, String percentage,
			String new_price, Date start_date, Date end_date) {
		super();
		this.property_id = property_id;
		this.user = user_id;
		this.pro_price = pro_price;
		this.status = status;
		this.percentage = percentage;
		this.new_price = new_price;
		this.start_date = start_date;
		this.end_date = end_date;
	}




	public int getUser() {
		return user;
	}
	
	
	public void setUser(int user) {
		this.user = user;
	}


	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public int getProperty_id() {
		return property_id;
	}



	public void setProperty_id(int property_id) {
		this.property_id = property_id;
	}



	public String getPercentage() {
		return percentage;
	}



	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}



	public String getNew_price() {
		return new_price;
	}



	public void setNew_price(String new_price) {
		this.new_price = new_price;
	}



	public Date getStart_date() {
		return start_date;
	}



	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}



	public Date getEnd_date() {
		return end_date;
	}



	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getPro_price() {
		return pro_price;
	}



	public void setPro_price(String pro_price) {
		this.pro_price = pro_price;
	}


	@Override
	public String toString() {
		return "Promotion [id=" + id + ", property_id=" + property_id + ", user_id=" + user + ", pro_price="
				+ pro_price + ", status=" + status + ", percentage=" + percentage + ", new_price=" + new_price
				+ ", start_date=" + start_date + ", end_date=" + end_date + "]";
	}




	

		
}








	
	
	
	


