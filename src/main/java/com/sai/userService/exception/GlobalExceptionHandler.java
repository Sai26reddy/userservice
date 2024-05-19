package com.sai.userService.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sai.userService.payload.ApiResponse;



@RestControllerAdvice
public class GlobalExceptionHandler {
	

	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> ResourceNotFoundExcepion(ResourceNotFoundException e){
		String message = e.getMessage();
		ApiResponse apiresponse = ApiResponse.builder().message(message).success(false).status(HttpStatus.BAD_REQUEST).build();
		return new ResponseEntity<>(apiresponse,HttpStatus.BAD_GATEWAY);
	}
}
