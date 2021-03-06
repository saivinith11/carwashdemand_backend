package com.adminservice.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="admindetails")
public class Adminlogin {
	@NotEmpty(message="name should not be empty")
    String username;
	@NotEmpty(message="name should not be empty")
    String password;
    
	
	
	public Adminlogin(String username, @NotEmpty(message = "name should not be empty") String password) {
		super();
		this.username = username;
		this.password = password;
	}


	@Override
	public String toString() {
		return "AdminDetails [username=" + username + ", password=" + password + "]";
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Transient
	public static final String SEQUENCE_NAME = "users_sequence";
	
	
	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}
	
	
	
}
