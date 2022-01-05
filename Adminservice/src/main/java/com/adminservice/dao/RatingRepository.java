package com.adminservice.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.adminservice.model.Ratings;
@Repository
public interface RatingRepository extends MongoRepository<Ratings, Integer>{

}
