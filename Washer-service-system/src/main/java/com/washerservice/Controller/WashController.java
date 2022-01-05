package com.washerservice.Controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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

import com.washerservice.Model.Orderdetails;
import com.washerservice.Model.Ratings;
import com.washerservice.Model.Washerdetails;
import com.washerservice.Repository.WasherRepo;

import com.washerservice.service.WasherServiceImpl;

import io.swagger.annotations.ApiOperation;
@CrossOrigin(origins = "http://localhost:3001")
@RestController
@RequestMapping("/wash")
public class WashController {

	@Autowired
	private WasherServiceImpl service;
	
	@Autowired
	private RestTemplate restTemplate;

	
	@PostMapping("/addwasher")
	@ApiOperation(value = "To Add washer Details")
	public String saveWasher(@RequestBody Washerdetails washer) {
	washer.setId(service.getSequenceNumber(Washerdetails.SEQUENCE_NAME));
	service.save(washer);//washer will save his details
	return "washer details Succesfull!!!";
	} 
	
	@GetMapping("/allwashers")
	@ApiOperation(value = "To Get all washer Details")
	public List<Washerdetails> findAll() {
	return service.findAll();
	}
	
	@GetMapping("/allwashers/{location}")
	@ApiOperation(value="to get washer location")
	public List<Washerdetails> getloaction(@PathVariable String location)
	{
	return service.getwasherdetailsbylocation(location);
	}
	
	@GetMapping("/allwasher/{id}")
	@ApiOperation(value="to get washer id")
	public Optional<Washerdetails> getid(@PathVariable int id)
	{
	return service.getwasherbyid(id);
	}
	
	
	@DeleteMapping("/deletewasher")
	@ApiOperation(value = "To delete pack Details")
	public String deletepack(@RequestBody Washerdetails wash,@RequestParam int id ) {
	service.deletewasher(id);
	return "delete  pack Succesfull!!!"; 
	}
	
	@GetMapping("/allratings")
	public List<Ratings> getallratings(){
		String baseurl="http://localhost:8082/admin/allratings";
		Ratings[] allratings=restTemplate.getForObject(baseurl, Ratings[].class);
		
		return Arrays.asList(allratings);
	}
	
    @GetMapping("/allorders")
	public List<Orderdetails> getallorders(){
		String baseurl="http://localhost:8085/order/allorders";
		Orderdetails[] allorders=restTemplate.getForObject(baseurl, Orderdetails[].class);
		
		return Arrays.asList(allorders);
	
}
}
