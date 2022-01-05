package com.washerservice.service;

import java.util.List;
import java.util.Optional;

import com.washerservice.Model.Washerdetails;


public interface WasherService {
	public void save(Washerdetails washerdetails);

	public List<Washerdetails> findAll();
	
	public List<Washerdetails> getwasherdetailsbylocation(String location);
	
	public Optional<Washerdetails> getwasherbyid(int id);

	public void deletewasher(int id);
}
