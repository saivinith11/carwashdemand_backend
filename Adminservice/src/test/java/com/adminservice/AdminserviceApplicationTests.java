package com.adminservice;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.adminservice.dao.AdminRepository;
import com.adminservice.model.Adminlogin;
import com.adminservice.service.AdminServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
class AdminserviceApplicationTests {

	@Autowired
	private AdminServiceImpl serv;

	@MockBean
	private AdminRepository repos;

	@Test 
	public void getUsersTest() {
	when(repos.findAll()).thenReturn(Stream
	.of(new Adminlogin("sai","sai"),
	new Adminlogin("sai","vini")).collect(Collectors.toList()));
	assertEquals(2, serv.findAll().size());
	}
	
	/*@Test
	public void saveUserTest() {
		AdminDetails user = new AdminDetails( 1,"sai");
		when(repos.save(user)).thenReturn(user);
		assertEquals(user, serv.save(user));
    }*/
	
}
