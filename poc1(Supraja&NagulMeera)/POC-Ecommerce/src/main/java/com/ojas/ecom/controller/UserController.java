package com.ojas.ecom.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ojas.ecom.model.User;
import com.ojas.ecom.response.UserResponse;
import com.ojas.ecom.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	Logger logger = Logger.getLogger(this.getClass());

	@PostMapping(value = "/createuser", produces = { "application/json", "application/xml" }, consumes = {
			"application/json", "application/xml" })
	public ResponseEntity<Object>saveUser(@RequestBody User user)  {
		logger.debug("data coming into controller");
     
		return userService.saveUser(user);
	}
    
      
}
