package com.emp.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.model.User;
import com.emp.response.UserResponse;
import com.emp.service.UserServiceInterface;

@RestController
@RequestMapping("/user")
public class UserController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UserServiceInterface userService;

	@PostMapping(value = "/createUser", produces = { "application/json", "application/xml" }, consumes = {
			"application/json", "application/xml" })
	public UserResponse save(@RequestBody User user) {
		logger.info("inside save method of a user");
		return userService.save(user);
	}
}
