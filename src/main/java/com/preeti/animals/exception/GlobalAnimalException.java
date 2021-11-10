package com.preeti.animals.exception;

public class GlobalAnimalException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String message;

	public GlobalAnimalException(String message) {
		super(message);
		this.message = message;
	}

	public GlobalAnimalException() {

	}
}
