package com.paymentservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paymentservice.model.paymentdetails;
import com.paymentservice.service.PaymentService;

@RestController
@RequestMapping("/pay")
public class Maincontroller {
	@Autowired
    public PaymentService paymentservice;
	
	@PostMapping("/payment")
	public paymentdetails dopayment(@RequestBody paymentdetails payment) {
		return paymentservice.pay(payment);
	}
	
	@GetMapping("/allpayments")
	public List<paymentdetails> getpay()
	{
		return paymentservice.getpayment();
	}
}
