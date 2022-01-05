package com.usermanagement.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.usermanagement.model.SignUp;
@Repository
public interface UserRepository extends MongoRepository<SignUp, Integer>{
	
	public SignUp findById(int id);
}
