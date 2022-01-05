package com.paymentservice.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.paymentservice.model.paymentdetails;
@Repository
public interface PaymentRepository extends MongoRepository<paymentdetails, Integer>{

}
