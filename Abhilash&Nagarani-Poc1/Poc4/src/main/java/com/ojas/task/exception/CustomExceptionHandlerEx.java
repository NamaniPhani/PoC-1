package com.ojas.task.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ojas.task.response.Response;

@ControllerAdvice
public class CustomExceptionHandlerEx {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<?> methodArgumentexceptionHandlerMethod(MethodArgumentNotValidException e) {
		Response response = new Response();
		response.setMessage(e.getBindingResult().getFieldError().getDefaultMessage());
		response.setStatus(400);
		return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
	}
	
}
