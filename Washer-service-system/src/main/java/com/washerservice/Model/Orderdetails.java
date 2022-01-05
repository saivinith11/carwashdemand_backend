package com.washerservice.Model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="orderdetails")
public class Orderdetails {
	
	@Id
  private Long id;
  @NotEmpty(message="carname should not be empty")
  private String CarName;
  @NotEmpty(message="model should not be empty")
  private String Model;
  @NotEmpty(message="washername should not be empty")
  private String washerName;
  @NotNull(message="washpackageid should not be empty")
  private int washpackageId;
  @NotNull(message="preffered should not be empty")
  private String PrefferedDate;
  @NotNull(message="contactNo should not be empty")
  private int contactNo;
  
  
  
  
public Orderdetails() {
	super();
}
@Transient
public static final String SEQUENCE_NAME = "users_sequence";




public static String getSequenceName() {
	return SEQUENCE_NAME;
}

public Orderdetails( String carName, String model, String washerName, int washpackageId, String prefferedDate,
		int contactNo) {
	super();
	CarName = carName;
	Model = model;
	this.washerName = washerName;
	this.washpackageId = washpackageId;
	PrefferedDate = prefferedDate;
	this.contactNo = contactNo;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getCarName() {
	return CarName;
}

public void setCarName(String carName) {
	CarName = carName;
}

public String getModel() {
	return Model;
}

public void setModel(String model) {
	Model = model;
}

public String getWasherName() {
	return washerName;
}


public void setWasherName(String washerName) {
	this.washerName = washerName;
}

public int getWashpackageId() {
	return washpackageId;
}

public void setWashpackageId(int washpackageId) {
	this.washpackageId = washpackageId;
}

public String getPrefferedDate() {
	return PrefferedDate;
}

public void setPrefferedDate(String prefferedDate) {
	PrefferedDate = prefferedDate;
}

public int getContactNo() {
	return contactNo;
}

public void setContactNo(int contactNo) {
	this.contactNo = contactNo;
}

@Override
public String toString() {
	return "Orderdetails [id=" + id + ", CarName=" + CarName + ", Model=" + Model + ", washerName=" + washerName
			+ ", washpackageId=" + washpackageId + ", PrefferedDate=" + PrefferedDate + ", contactNo=" + contactNo
			+ "]";
}

  
  
  
}
