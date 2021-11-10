package com.preeti.animals.exception;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global Exception handler class.
 * 
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(value = GlobalAnimalException.class)
	public ResponseEntity<ExceptionResponse> globalAnimalException(GlobalAnimalException ex) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.name());
		response.setErrorMessage(ex.getMessage());
		response.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = DuplicateAnimalException.class)
	public ResponseEntity<ExceptionResponse> duplicateAnimalException(DuplicateAnimalException ex) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorCode(HttpStatus.CONFLICT.name());
		response.setErrorMessage(ex.getMessage());
		response.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.CONFLICT);
	}

	@ExceptionHandler(value = AnimalNotFoundException.class)
	public ResponseEntity<ExceptionResponse> animalNotFoundExceptio(AnimalNotFoundException ex) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorCode(HttpStatus.NOT_FOUND.name());
		response.setErrorMessage(ex.getMessage());
		response.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ExceptionResponse> globalExceptio(Exception ex) {
		logger.error("Exception in handling animal operation : ", ex);
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.name());
		response.setErrorMessage(ex.getMessage());
		response.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
