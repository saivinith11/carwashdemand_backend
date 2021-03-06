package com.adminservice.service;

import java.util.List;
import java.util.Optional;

import com.adminservice.model.Adminlogin;
import com.adminservice.model.Ratings;
import com.adminservice.model.Washpacks;

public interface AdminService {
	public List<Adminlogin> findAll();

	public void save(Adminlogin admindetails);

	public void updateDetails(int id,Adminlogin admin);

	public void deleteadmin(int id);
	
	//packs
	
	public void save(Washpacks washpacks);
	
	public List<Washpacks> findAllpacks();
	
	public void deletepack(int id);
	
	public void updatepacks(int id,Washpacks wash);
	
	//Ratings
	
	public void save(Ratings ratings);
	
	public List<Ratings> findratings();
}




