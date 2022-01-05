package com.orderservice.service;

import java.util.List;
import java.util.Optional;

import com.orderservice.model.Orderdetails;

public interface Orderservice {

	public void save(Orderdetails orderdetails);
	
	public List<Orderdetails> findAll();
	
	public Optional<Orderdetails> getorderdetailbyid(int id);
	
	public void updateDetails(int id,Orderdetails order);

	public void deleteorder(int id);
	
	
	

}
