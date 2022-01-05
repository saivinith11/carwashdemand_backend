package com.paymentservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="paymentdetails")
public class paymentdetails {
	@Id
	private long orderId;
	private float amount;
	private String paymentstatus;
	private String transactionid;
	
	@Transient
	public static final String SEQUENCE_NAME = "users_sequence";
	
	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}

	public paymentdetails( float amount, String paymentstatus, String transactionid) {
		super();
		
		this.amount = amount;
		this.paymentstatus = paymentstatus;
		this.transactionid = transactionid;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getPaymentstatus() {
		return paymentstatus;
	}

	public void setPaymentstatus(String paymentstatus) {
		this.paymentstatus = paymentstatus;
	}

	public String getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(String transactionid) {
		this.transactionid = transactionid;
	}

	@Override
	public String toString() {
		return "paymentdetails [orderId=" + orderId + ", amount=" + amount + ", paymentstatus=" + paymentstatus
				+ ", transactionid=" + transactionid + "]";
	}

	public void setId(long sequenceNumber) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
