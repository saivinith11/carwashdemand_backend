package com.washerservice.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.washerservice.Model.Washerdetails;
@Repository
public interface WasherRepo extends MongoRepository<Washerdetails, Integer> {

	List<Washerdetails> findBylocation(String location);



	
	
}
