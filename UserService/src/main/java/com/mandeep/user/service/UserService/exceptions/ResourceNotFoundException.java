package com.mandeep.user.service.UserService.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	public ResourceNotFoundException(String msg) {
		super(msg);
	}
	public ResourceNotFoundException() {
		super("Resource not found");
	}

}
