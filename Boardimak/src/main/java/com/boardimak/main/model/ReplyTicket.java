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
@Table(name="replyticket")
public class ReplyTicket {
	
	
	@Id
	@Column(name="reply_id")
	private int id;
	private int ticket_id;
	private int user_id;
	private String reply_msg;
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="replied_date")
	private Date replied_date;
	
	public ReplyTicket() {
	}

	public ReplyTicket(int ticket_id, int user_id, String reply_msg, Date replied_date) {
		super();
		this.ticket_id = ticket_id;
		this.user_id = user_id;
		this.reply_msg = reply_msg;
		this.replied_date = replied_date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTicket_id() {
		return ticket_id;
	}

	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getReply_msg() {
		return reply_msg;
	}

	public void setReply_msg(String reply_msg) {
		this.reply_msg = reply_msg;
	}

	public Date getReplied_date() {
		return replied_date;
	}

	public void setReplied_date(Date replied_date) {
		this.replied_date = replied_date;
	}

	@Override
	public String toString() {
		return "ReplyTicket [id=" + id + ", ticket_id=" + ticket_id + ", user_id=" + user_id + ", reply_msg="
				+ reply_msg + ", replied_date=" + replied_date + "]";
	}
	
	
	

}
