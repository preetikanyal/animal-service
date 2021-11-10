package com.preeti.animals.exception;

/**
 * Exception class when animal not found in DB.
 * 
 */
public class AnimalNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String message;

	public AnimalNotFoundException(String message) {
		super(message);
		this.message = message;
	}

	public AnimalNotFoundException() {

	}
}
