package com.ojas.ecom.customexception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ojas.ecom.response.JobResponse;

@ControllerAdvice
public class ExceptionHandlerEx {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)

	public ResponseEntity<?> methodArgumentexceptionHandlerMethod(MethodArgumentNotValidException e) {
		JobResponse response = new JobResponse();
		response.setMessage(e.getBindingResult().getFieldError().getDefaultMessage());
		response.setStatusCode("400");
		return new ResponseEntity<JobResponse>(response, HttpStatus.BAD_REQUEST);
	}
}
