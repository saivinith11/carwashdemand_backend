package com.usermanagement.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usermanagement.dao.UserRepository;
import com.usermanagement.model.Login;
import com.usermanagement.model.SignUp;
@Service
public class LoginService {
	@Autowired
	private UserRepository userRepository;
     
	public String userLogin(Login login) {
		ArrayList<SignUp> list=(ArrayList<SignUp>) userRepository.findAll();
		int count=0;
		
		for(int i=0;i<list.size();i++)
		{
			
			if(list.get(i).getUsername().equals(login.getUsername()) && list.get(i).getPassword().equals(login.getPassword()))
			{
				
				count++;
			}
		}
		
		if(count==1)
		{
			return "logged in";
		}
		else
		{
			return "wrong credentials";
		}
	

	}

	
}



