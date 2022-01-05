package com.usermanagement;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.assertEquals;

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

import com.usermanagement.dao.UserRepository;
import com.usermanagement.model.SignUp;
import com.usermanagement.service.UserServiceImpl;
@RunWith(SpringRunner.class)
@SpringBootTest
class UserManagementApplicationTests {
	@MockBean
	private UserRepository repo ;

	@Autowired
	private UserServiceImpl service;
	
	@Test
	public void getusertest() {
		when(repo.findAll()).thenReturn(Stream
				.of(new SignUp( "saivini","sai123@gmail.com",78, "sai123" , "12345" ,"12345"),
				new SignUp( "vinith","vini123@gmail.com",78, "vini123" , "123456" ,"123456")).collect(Collectors.toList()));

				assertEquals(2, service.findAll().size());

}

	/*@Test
	public void saveuserTest() {
	SignUp user = new SignUp("jahn","sai@123.com",57,"saivinith","sai","sai");
	when(repo.save(user)).thenReturn(user);
	assertEquals(user,service.save1(user));
	}


	@Test public void deleteUserTest(){
	SignUp user = new SignUp("jahn","sai@123.com",57,"saivinith","sai","sai");
	service.deleteuser(user); verify(repo,times(1)).delete(user);

	}*/
}

