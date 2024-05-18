package com.sai.user.service.exception;

public class ResourceNotFoundException extends RuntimeException{
	public ResourceNotFoundException() {
		super("Resource was not found");
	}
	public ResourceNotFoundException(String message) {
		super(message);
	}
}
