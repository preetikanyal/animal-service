package com.preeti.animals.exception;

/**
 * Exception class when animal with given name already exist.
 * 
 */
public class DuplicateAnimalException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String message;

	public DuplicateAnimalException(String message) {
		super(message);
		this.message = message;
	}

	public DuplicateAnimalException() {

	}

}
