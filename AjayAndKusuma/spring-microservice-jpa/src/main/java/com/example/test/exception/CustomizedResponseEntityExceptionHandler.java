package com.example.test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.test.response.ErrorResponse;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<?> methodArgumentexceptionHandlerMethod(MethodArgumentNotValidException e) {
		ErrorResponse response = new ErrorResponse();
		response.setMessage(e.getBindingResult().getFieldError().getDefaultMessage());
		response.setStatusCode(400);
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(InvalidDataException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<?> methodArgumentexceptionHandlerMethod(InvalidDataException e) {
		ErrorResponse response = new ErrorResponse();
		response.setMessage(e.getMessage());
		response.setStatusCode(400);
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.BAD_REQUEST);
	}

}
