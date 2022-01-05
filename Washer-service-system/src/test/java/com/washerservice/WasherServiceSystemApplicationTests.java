package com.washerservice;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.washerservice.Model.Washerdetails;
import com.washerservice.Repository.WasherRepo;
import com.washerservice.service.WasherServiceImpl;

@SpringBootTest
@RunWith(SpringRunner.class)
class WasherServiceSystemApplicationTests {

	@Autowired
	private WasherServiceImpl serv;

	@MockBean
	private WasherRepo repos;

	@Test public void getUsersTest() {
	when(repos.findAll()).thenReturn(Stream
	.of(new Washerdetails("vinith","hyd"),
	new Washerdetails("munna","hyd")).collect(Collectors.toList()));
	assertEquals(2, serv.findAll().size());
	}

	@Test public void getUserByAddressTest() {
	String location="cc";
	when(repos.findBylocation(location))
	.thenReturn(Stream.of(new Washerdetails("munna","hyd")).collect(Collectors.toList()));

	assertEquals(1, serv.getwasherdetailsbylocation(location).size());
	}

	/*@Test public void saveUserTest() {
	Washerdetails washer = new Washerdetails("sathvik","USA");
	when (repos.save(washer)).thenReturn(washer);
	assertEquals(washer, serv.save(washer));
	}

	@Test public void deleteUserTest() {
	Washerdetails washer = new Washerdetails("sathvik","USA");
	serv.deletewasher(washer);
	verify(repos,times(1)).delete(washer);
	} */

}
