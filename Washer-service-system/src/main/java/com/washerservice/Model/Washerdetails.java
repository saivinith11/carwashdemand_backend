package com.washerservice.Model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="washerinfo")
public class Washerdetails {

	@Id
	private long id;
	@NotEmpty(message="name should not be empty")
	private String name;
	@NotEmpty(message="location should not be empty")
	private String location;
	
	@Transient
	public static final String SEQUENCE_NAME = "users_sequence";
	
	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}

	public Washerdetails(String name, String location) {
		super();
		this.name = name;
		this.location = location;
		
	}
	
	public Washerdetails() {
		super();
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
	@Override
	public String toString() {
		return "Washerdetails [id=" + id + ", name=" + name + ", location=" + location + "]";
	}
	
	
	
}
