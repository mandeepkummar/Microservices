package com.mandeep.rating.RatingService.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	public ResourceNotFoundException() {
		super("Rating not found for the given ratingId");
	}
	public ResourceNotFoundException(String msg) {
		super(msg);
	}
}
