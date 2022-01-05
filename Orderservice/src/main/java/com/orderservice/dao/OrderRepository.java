package com.orderservice.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.orderservice.model.Orderdetails;
@Repository
public interface OrderRepository extends MongoRepository<Orderdetails, Integer>{

}
