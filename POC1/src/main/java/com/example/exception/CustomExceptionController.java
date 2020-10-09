package com.example.exception;

import static com.example.exception.Constants.*;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.Response.Response;

@ControllerAdvice
public class CustomExceptionController extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = CustomException.class)
	public ResponseEntity<Object> customException(CustomException cusException, Exception ex) {
		String localizedMessage = cusException.getLocalizedMessage();
		Response response = new Response();
		response.setStatuscode(FAIL_STATUS);
		response.setStatus(FAIL);
		response.setMessage(localizedMessage);
		response.setTimestamp(new Date());
		return new ResponseEntity<>(response, HttpStatus.UNPROCESSABLE_ENTITY);
	}

}
