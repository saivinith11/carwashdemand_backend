package com.usermanagement.controller;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
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

import com.usermanagement.model.Login;
import com.usermanagement.model.Orderdetails;
import com.usermanagement.model.Ratings;
import com.usermanagement.model.SignUp;
import com.usermanagement.model.Washpacks;
import com.usermanagement.model.paymentdetails;
import com.usermanagement.service.LoginService;
import com.usermanagement.service.UserService;

import io.swagger.annotations.ApiOperation;
@RestController
@CrossOrigin(origins = "http://localhost:3001")
@RequestMapping("/carwash")
public class Controller {
	
	@Autowired
	private UserService service;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private LoginService loginservice;
	
    
	
	
	@PostMapping("/adduser")
	@ApiOperation(value = "To Add User Details")
	public String saveAdmin(@Valid @RequestBody SignUp signup) {
	signup.setId(service.getSequenceNumber(SignUp.SEQUENCE_NAME));
	service.save1(signup);//user will save his details
	return "signup Succesfull!!!";
	} 
	
	
	
	
	@PutMapping("/update/{id}")
	@ApiOperation(value="Update userdetails by id")
	public String updateuserdetails(@PathVariable("id") int id,@Valid @RequestBody SignUp signup)
	{
	service.updateuserdetails(id,signup);
	return "update succesfull";
	}
	
	
	
	@GetMapping("/allusers")
	@ApiOperation(value = "To Get all User Details")
	public List<SignUp> findAll() {
	return service.findAll();
	}
	
	
	
	@DeleteMapping("/delete")
	@ApiOperation(value = "To delete user Details")
	public String deleteadmin(@RequestBody SignUp signup,@RequestParam int id ) {
	service.deleteuser(id);
	return "delete Succesfull!!!"; 
	}
	
	
	
	@GetMapping("/allpacks")
	@ApiOperation(value = "To get all packs")
	public List<Washpacks> getallratings(){
		String baseurl="http://localhost:8082/admin/allpacks";
		Washpacks[] wp=restTemplate.getForObject(baseurl, Washpacks[].class);
		
		return Arrays.asList(wp);
	}


	@PostMapping("/addpayment")
	@ApiOperation(value = "To add payment details")
	public String payment(@RequestBody paymentdetails payment) {
	HttpHeaders headers = new HttpHeaders();
	headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	HttpEntity<paymentdetails> entity = new HttpEntity<paymentdetails>(payment,headers);

	return restTemplate.exchange(
	"http://localhost:8086/pay/payment", HttpMethod.POST, entity, String.class).getBody();
	}

	@PostMapping("/addrating")
	@ApiOperation(value = "To add the ratings")
	public String addrating(@RequestBody Ratings rating) {
	HttpHeaders headers = new HttpHeaders();
	headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	HttpEntity<Ratings> entity = new HttpEntity<Ratings>(rating,headers);

	return restTemplate.exchange(
	"http://localhost:8082/admin/addratings", HttpMethod.POST, entity, String.class).getBody();
	}

	@PostMapping("/addorder")
	@ApiOperation(value = "To add the orders")
	public String addorder(@RequestBody Orderdetails order) {
	HttpHeaders headers = new HttpHeaders();
	headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	HttpEntity<Orderdetails> entity = new HttpEntity<Orderdetails>(order,headers);
	return restTemplate.exchange(
	"http://localhost:8085/order/addorder", HttpMethod.POST, entity, String.class).getBody();
	}



	 @DeleteMapping("/cancelorder")
	 @ApiOperation(value = "To cancel the order")
	 public String deleteorder(){
     String baseurl="http://localhost:8085/order/deleteorder/{id}";
	 Orderdetails order=restTemplate.getForObject(baseurl, Orderdetails.class);
	 return "Your Order is successfully Canceled "+order;
	 }
	 
	 @PostMapping("/login")
	 @ApiOperation(value = "To Add Login Details")
		public String dopayment(@RequestBody Login login) {
			return loginservice.userLogin(login);
		}
}

