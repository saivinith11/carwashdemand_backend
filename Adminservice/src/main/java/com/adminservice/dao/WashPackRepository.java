package com.adminservice.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.adminservice.model.Washpacks;
@Repository
public interface WashPackRepository extends MongoRepository<Washpacks, Integer>{

	
}
