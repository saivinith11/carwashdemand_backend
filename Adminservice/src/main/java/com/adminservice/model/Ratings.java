package com.adminservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="ratings")
public class Ratings {
	
	@Id
	int rating;
	String Washername;
	String comment;
	
	
	public Ratings(int rating, String washername, String comment) {
		super();
		this.rating = rating;
		Washername = washername;
		this.comment = comment;
	}
	
	
	public Ratings() {
		super();
	}


	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getWashername() {
		return Washername;
	}
	public void setWashername(String washername) {
		Washername = washername;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	

}
