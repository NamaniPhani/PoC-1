package com.ojas.poc4.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ojas.poc4.model.User;
import com.ojas.poc4.service.UserService;
import com.ojas.poc4.util.StandardResponse;
import com.ojas.poc4.util.UserResponse;

/**
 * @author Prasad Rachamalla
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	/**
	 * @param user
	 * @method createJobModel
	 * This method is used to create user taking in put request as User entity
	 * @return UserResponse
	 */
	@PostMapping("/createuser")	
	public ResponseEntity<StandardResponse> createJobModel(@Valid @RequestBody User user){
		StandardResponse response =	userService.saveUser(user);
		return new ResponseEntity<StandardResponse>(response, new HttpHeaders(), HttpStatus.ACCEPTED);
	}
	


}
