package com.ojas.ecom.customexception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ojas.ecom.response.JobResponse;

@ControllerAdvice
public class CustomizedController {

	@ExceptionHandler(CustomizedException.class)
	public ResponseEntity<Object> customException(CustomizedException cx) {
		JobResponse response = new JobResponse();
		response.setMessage(cx.getLocalizedMessage());
		return new ResponseEntity<Object>(response, HttpStatus.UNPROCESSABLE_ENTITY);
	}

}
