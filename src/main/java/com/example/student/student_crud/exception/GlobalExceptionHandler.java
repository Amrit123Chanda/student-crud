package com.example.student.student_crud.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler   {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String,Object>> resourceNotFound(ResourceNotFoundException ex)
	{
		Map<String,Object> error=new HashMap<>();
		error.put("message", ex.getMessage());
		error.put("status",HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String,Object>> generalException(Exception ex)
	{
		Map<String,Object> error=new HashMap<>();
		//error.put("message0", "I hope you entered correct value");
		error.put("message", ex.getMessage());
		error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	
}
