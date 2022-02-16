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
@Table(name = "cmsother")
public class CmsOther {

	@Id
	private int id;
	private String title;
	private String description;
	private String status;

	private String author;
	private String type;
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_time")
	private Date date_time;

	public CmsOther() {

	}
	
	public CmsOther(int a) {
		id=a;
	}

	public CmsOther(int id, String title, String description, String status, String author, Date date_time,String type) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.status = status;
		this.author = author;
		this.date_time = date_time;
		this.type=type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getDate_time() {
		return date_time;
	}

	public void setDate_time(Date date_time) {
		this.date_time = date_time;
	}

	@Override
	public String toString() {
		return "CmsOther [id=" + id + ", title=" + title + ", description=" + description + ", status=" + status
				+ ", author=" + author + ", type=" + type + ", date_time=" + date_time + "]";
	}

	

}
