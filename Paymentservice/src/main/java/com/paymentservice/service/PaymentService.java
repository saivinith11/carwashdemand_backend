package com.paymentservice.service;

import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.paymentservice.dao.PaymentRepository;

import com.paymentservice.model.paymentdetails;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepository paymentrepo;
	
	public paymentdetails pay(paymentdetails payment) {
		payment.setPaymentstatus(paymentstatus());
		payment.setTransactionid(UUID.randomUUID().toString());
		return paymentrepo.save(payment);
	}
	private String paymentstatus() {
		 return new Random().nextBoolean()?"success":"failure";
	}
	
	
	public List<paymentdetails> getpayment() {
		List<paymentdetails> payment= paymentrepo.findAll();
		System.out.println("Getting data from DB : " + payment);
		return payment;
		
	}
	
}
