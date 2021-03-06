package com.orderservice.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.orderservice.model.Orderdetails;

import com.orderservice.service.OrderServiceImpl;
import com.orderservice.service.Orderservice;

import io.swagger.annotations.ApiOperation;
@CrossOrigin(origins = "http://localhost:3001")
@RestController
@RequestMapping("/order")
public class OrderController {
	
    @Autowired
	private OrderServiceImpl service;
    
	@PostMapping("/addorder")
	@ApiOperation(value = "To Add order Details")
	public String saveAdmin(@RequestBody Orderdetails orderdetails) {
	orderdetails.setId(service.getSequenceNumber(Orderdetails.SEQUENCE_NAME));
	service.save(orderdetails);//user will save his details
	return "order placed Succesfull!!!";
	} 
	
	
	
	
	@GetMapping("/allorders")
	@ApiOperation(value = "To Get all order Details")
	public List<Orderdetails> findAll() {
	return service.findAll();
	}
	
	@GetMapping("/allorders/{id}")
	@ApiOperation(value="to get order id")
	public Optional<Orderdetails> getid(@PathVariable int id)
	{
	return service.getorderdetailbyid(id);
	}
	

	
	@PutMapping("/updateorder/{id}")
	@ApiOperation(value = "To update order Details")
	public String updateDetails(@RequestBody Orderdetails order,@PathVariable int id ) {
	service.updateDetails(id,order);
	return "update order Succesfull!!!";
	} 
	
	
	
	
	@DeleteMapping("/deleteorder/{id}")
	@ApiOperation(value = "To delete order Details")
	public String deleteorderbyid(@PathVariable int id ) {
	service.deleteorder(id);
	return "delete order Succesfull!!!"; 
	}
}
