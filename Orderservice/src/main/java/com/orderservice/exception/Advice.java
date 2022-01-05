package com.orderservice.exception;

import java.util.NoSuchElementException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class Advice {
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<?> handler(CustomException ex)
	{
		return ResponseEntity.badRequest().body(ex.getMessage());
	}
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<?> handle(NoSuchElementException ex)
	{
		return ResponseEntity.badRequest().body("no such user");
	}

}
