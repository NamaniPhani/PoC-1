package com.ojas.poc4.exception;

import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ojas.poc4.service.JobServiceImpl;
import com.ojas.poc4.util.StandardResponse;


@ControllerAdvice
public class PocCustExceptionHandler {
	Logger log = LoggerFactory.getLogger(JobServiceImpl.class);
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	  public final ResponseEntity<StandardResponse> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
		log.info("In methodArgumentNotValidException");
		StandardResponse response = new StandardResponse();
		 ex.getBindingResult().getFieldErrors().forEach(error -> 
		 response.setMessage(error.getDefaultMessage()));
	    return new ResponseEntity<StandardResponse>(response, HttpStatus.NOT_FOUND);
	  }
	
	@ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<StandardResponse> uniqueExceptionHandlerMethod(ConstraintViolationException e) {
		log.info("In uniqueExceptionHandlerMethod");
		StandardResponse response = new StandardResponse();
        response.setMessage(e.getMessage());       
        return new ResponseEntity<StandardResponse>(response, HttpStatus.BAD_REQUEST);
    }
	@ExceptionHandler(CustException.class)    
    public ResponseEntity<StandardResponse> custExceptionHandlerMethod(CustException e) {
		log.info("In custExceptionHandlerMethodMethod");
		StandardResponse response = new StandardResponse();
		response.setStatusCode(400);      
        response.setMessage(e.getMessage());       
        return new ResponseEntity<StandardResponse>(response, HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(Exception.class)    
    public ResponseEntity<StandardResponse> commonExceptionHandlerMethod(Exception e) {
		log.info("In custExceptionHandlerMethodMethod");
		StandardResponse response = new StandardResponse();
		response.setStatusCode(400);      
        response.setMessage(e.getMessage());       
        return new ResponseEntity<StandardResponse>(response, HttpStatus.BAD_REQUEST);
    }



	
}
