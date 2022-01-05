package com.adminservice.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class Advice extends ResponseEntityExceptionHandler {
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
	
	
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, org.springframework.http.HttpStatus status, WebRequest request) {
		
	Map<String, String> map = new HashMap<>();
	List<ObjectError> list = ex.getBindingResult().getAllErrors();
	for (int i = 0; i < list.size(); i++) 
	{
	String fieldName = ((FieldError) list.get(i)).getField();
    map.put(fieldName, list.get(i).getDefaultMessage());
	}
	map.put("status", status.toString());
	map.put("Timestamp", new Date().toString());

	return ResponseEntity.badRequest().body(map);
	}
	

}
