package com.adminservice.controller;

import java.util.Arrays;


import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.adminservice.dao.AdminRepository;
import com.adminservice.dao.RatingRepository;
import com.adminservice.dao.WashPackRepository;
import com.adminservice.model.Adminlogin;
import com.adminservice.model.Orderdetails;
import com.adminservice.model.Ratings;
import com.adminservice.model.Washerdetails;
import com.adminservice.model.Washpacks;
import com.adminservice.service.AdminServiceImpl;


import io.swagger.annotations.ApiOperation;



@RestController
@CrossOrigin(origins = "http://localhost:3001")
@RequestMapping("/admin")
public class AdminController {
	
	
	@Autowired
	private AdminServiceImpl service;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@PostMapping("/addadmin")
	@ApiOperation(value = "To Add admin Details")
	public String saveAdmin(@RequestBody Adminlogin admin) {
	service.save(admin);//user will save his details
	return "Registered Succesfull!!!";
	} 
	
	

	
	
	
	@PutMapping("/updateadmin/{id}")
	@ApiOperation(value = "To update admin Details")
	public String updateDetails(@RequestBody Adminlogin admin,@PathVariable int id ) {
	service.updateDetails(id,admin);
	return "update Succesfull!!!";
	} 
	
	
	
	
	@GetMapping("/alladmins")
	@ApiOperation(value = "To Get all admin Details")
	public List<Adminlogin> findAll() {
	return service.findAll();
	}
	
	
	
	@DeleteMapping("/account/delete")
	@ApiOperation(value = "To delete admin Details")
	public String deleteadmin(@RequestBody Adminlogin admin,@RequestParam int id ) {
	service.deleteadmin(id);
	return "delete Succesfull!!!"; 
	}
	
	@PostMapping("/addpack")
	@ApiOperation(value = "To Add admin Details")
	public String savepack(@RequestBody Washpacks washpacks) {
	service.save(washpacks);//user will save his details
	return "packadded Succesfull!!!";
	} 
	
	
	@GetMapping("/allpacks")
	@ApiOperation(value = "To get pack Details")
	public List<Washpacks> findAllpacks() {
	return service.findAllpacks();
	}
	
	@DeleteMapping("/contact/delete")
	@ApiOperation(value = "To delete pack Details")
	public String deletepack(@RequestBody Washpacks wash,@RequestParam int id ) {
	service.deletepack(id);
	return "delete  pack Succesfull!!!"; 
	}
	
	
	@PutMapping("/updatepacks/{id}")
	@ApiOperation(value = "To update pack Details")
	public String updatepacks(@RequestBody Washpacks wash,@PathVariable int id ) {
	service.updatepacks(id,wash);
	return "update  packs Succesfull!!!";
	} 
	
	@PostMapping("/addratings")
	@ApiOperation(value = "To Add rating Details")
	public String saveratings(@RequestBody Ratings rating) {
	service.save(rating);
	return "Thanks for ur valuable feedback!!!";
	} 
	

	@GetMapping("/allratings")
	@ApiOperation(value = "To get rating Details")
	public List<Ratings> findAllRatings() {
	return service.findratings();
	}
	
	
	@GetMapping("/allorders")
	public List<Orderdetails> getallorders(){
	String baseurl="http://localhost:8085/order/allorders";
    Orderdetails[] allorders=restTemplate.getForObject(baseurl, Orderdetails[].class);
		
	return Arrays.asList(allorders);
	}
	
	@GetMapping("/allwashers")
	public List<Washerdetails> getallwashers(){
    String baseurl="http://localhost:8084/wash/allwashers";
	Washerdetails[] allwashers=restTemplate.getForObject(baseurl, Washerdetails[].class);
			
	return Arrays.asList(allwashers);


	}
	
}

	

