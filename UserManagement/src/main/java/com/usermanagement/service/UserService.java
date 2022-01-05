package com.usermanagement.service;

import java.util.List;

import com.usermanagement.model.SignUp;



public interface UserService {
	

	public void save1(SignUp signup);
	
	public List<SignUp> findAll();

	public void updateuserdetails(int id,SignUp signup);

	public void deleteuser(int id);
	
	public Long getSequenceNumber(String sequenceName);

}
