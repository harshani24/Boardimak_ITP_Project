package com.boardimak.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Users {

	 @Id
	    @GeneratedValue(strategy= GenerationType.IDENTITY)
	    @Column(name="user_id")
	    private int id;

	    @Column(name="first_name")
	    private String firstName;

	    @Column(name="last_name")
	    private String lastName;

	    @Column(name="email")
	    private String email;

	    @Column(name="password")
	    private String password;

	    @Column(name="user_name")
	    private String userName;

	    @Column(name="mobile_no")
	    private int mobileNo;

	    @Column(name="type")
	    private String type;
	    
	    @Column(name="child_id")
	    private String childID;
	    
	    @Column(name="stripe_id")
	    private String stripeId;
	    
	    @Column(name="account_id")
	    private String accountId;
	    
	    public Users() {
	    	
	    }

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public int getMobileNo() {
			return mobileNo;
		}

		public void setMobileNo(int mobileNo) {
			this.mobileNo = mobileNo;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getChildID() {
			return childID;
		}

		public void setChildID(String chileID) {
			this.childID = chileID;
		}

		public String getStripeId() {
			return stripeId;
		}

		public void setStripeId(String stripeId) {
			this.stripeId = stripeId;
		}

		public String getAccountId() {
			return accountId;
		}

		public void setAccountId(String accountId) {
			this.accountId = accountId;
		}
}
