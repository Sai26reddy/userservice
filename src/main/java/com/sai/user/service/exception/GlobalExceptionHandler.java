package com.sai.user.service.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sai.user.service.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@Autowired
	ApiResponse apiResponse;
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> ResourceNotFoundExcepion(ResourceNotFoundException e){
		String message = e.getMessage();
		apiResponse.setMessage(message);
		apiResponse.setSuccess(false);
		apiResponse.setStatus(HttpStatus.NOT_FOUND);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.BAD_REQUEST);
	}
}
