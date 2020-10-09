package com.emp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.emp.exception.Response;

@ControllerAdvice
public class ExceptionHandlerEx {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ResponseEntity<Response> ExceptionHandlerEx(MethodArgumentNotValidException ex) {
		Response response = new Response();
		response.setMessage(ex.getBindingResult().getFieldError().getDefaultMessage());
		response.setStatusCode("400");
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
}


