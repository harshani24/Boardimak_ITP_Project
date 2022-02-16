
package com.boardimak.main.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
public class Property {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="property_id")
	private int id;

	@Column(name="owner_id")
	private int ownerId;

	@Column(name="address_one")
	private String addressOne;

	@Column(name="address_two")
	private String addressTwo;
	
	@Column(name="city")
	private String city;

	@Column(name="type")
	private String PropertyType;

	@Column(name="monthly_payment")
	private String monthlyPayment;

	@Column(name="keymoney")
	private String keyMoney;

	@Column(name="no_of_rooms")
	private int noOfRooms;

	@Column(name="air_condition")
	private String airCondition;

	@Column(name="parking")
	private String parking;

	@Column(name="time_period")
	private String timePeriod;

	@Column(name="status")
	private String status;

	@Column(name="description")
	private String description;
	
	@Column(name="other_facilities")
	private String otherFacilities;
	
	@Column(name="image_name")
	private String imageName;
	
	@Column(name="file_type")
    private String fileType;

    @Lob
    @Column(name="data")
    private byte[] data;

	public Property() {
		super();
		this.id = 0;
		this.ownerId = 0;
		this.addressOne = "";
		this.addressTwo = "";
		this.city = "";
		PropertyType = "";
		this.monthlyPayment = "";
		this.keyMoney = "";
		this.noOfRooms = 0;
		this.airCondition = "";
		this.parking = "";
		this.timePeriod = "";
		this.status = "Active";
		this.description = "";
		this.otherFacilities = "";
		this.imageName ="";
		this.fileType="";
		this.data=null;
	}
	
	
	public Property(int id, int ownerId, String address1, String address2, String city, String propertyType,
			String monthlyPayment, String keyMoney, int noOfRooms, String airCondition, String parking,
			String timePeriod, String status, String description, String otherFacilities) {
		super();
		this.id = id;
		this.ownerId = ownerId;
		this.addressOne = address1;
		this.addressTwo = address2;
		this.city = city;
		PropertyType = propertyType;
		this.monthlyPayment = monthlyPayment;
		this.keyMoney = keyMoney;
		this.noOfRooms = noOfRooms;
		this.airCondition = airCondition;
		this.parking = parking;
		this.timePeriod = timePeriod;
		this.status = status;
		this.description = description;
		this.otherFacilities = otherFacilities;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getOwnerId() {
		return ownerId;
	}



	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}



	public String getAddressOne() {
		return addressOne;
	}



	public void setAddressOne(String addressOne) {
		this.addressOne = addressOne;
	}



	public String getAddressTwo() {
		return addressTwo;
	}



	public void setAddressTwo(String addressTwo) {
		this.addressTwo = addressTwo;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getPropertyType() {
		return PropertyType;
	}



	public void setPropertyType(String propertyType) {
		PropertyType = propertyType;
	}



	public String getMonthlyPayment() {
		return monthlyPayment;
	}



	public void setMonthlyPayment(String monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}



	public String getKeyMoney() {
		return keyMoney;
	}



	public void setKeyMoney(String keyMoney) {
		this.keyMoney = keyMoney;
	}



	public int getNoOfRooms() {
		return noOfRooms;
	}



	public void setNoOfRooms(int noOfRooms) {
		this.noOfRooms = noOfRooms;
	}



	public String getAirCondition() {
		return airCondition;
	}



	public void setAirCondition(String airCondition) {
		this.airCondition = airCondition;
	}



	public String getParking() {
		return parking;
	}



	public void setParking(String parking) {
		this.parking = parking;
	}



	public String getTimePeriod() {
		return timePeriod;
	}



	public void setTimePeriod(String timePeriod) {
		this.timePeriod = timePeriod;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getOtherFacilities() {
		return otherFacilities;
	}



	public void setOtherFacilities(String otherFacilities) {
		this.otherFacilities = otherFacilities;
	}


	public String getImageName() {
		return imageName;
	}


	public void setImageName(String imageName) {
		this.imageName = imageName;
	}


	public String getFileType() {
		return fileType;
	}


	public void setFileType(String fileType) {
		this.fileType = fileType;
	}


	public byte[] getData() {
		return data;
	}


	public void setData(byte[] data) {
		this.data = data;
	}
	
	

}
