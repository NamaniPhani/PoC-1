package com.ojas.task.controller;

import javax.validation.Valid;
import javax.ws.rs.QueryParam;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ojas.task.entity.User;
import com.ojas.task.exception.DuplicateUserException;
import com.ojas.task.response.Response;
import com.ojas.task.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService service;

	Logger logger = Logger.getLogger(this.getClass());

	@PostMapping(value = "/createuser", produces = { "application/json", "application/xml" }, consumes = {
			"application/json", "application/xml" })
	public Response saveUser(@Valid @RequestBody User user) {
		logger.debug("Inside create user method");

		User saveUser = null;
		Response resp = null;

		User userById = service.findByUserName(user.getUserName());
		try {
			if (userById == null) {
				saveUser = service.save(user);
				if (saveUser == null) {
					resp = new Response();
					resp.setStatus(409);
					resp.setMessage("User not saved");
					return resp;
				} else
					resp = new Response(saveUser, "User saved successfully", 200);
			} else
				throw new DuplicateUserException("User Already Existed");
			return resp;
		} catch (DuplicateUserException e) {
			logger.error("Inside catch block of create user");
			resp = new Response();
			resp.setStatus(409);
			resp.setMessage(e.getMessage());
			return resp;
		} catch (Exception e) {
			logger.error("Inside catch block of create user");
			resp = new Response();
			resp.setStatus(422);
			resp.setMessage(e.getMessage());
			return resp;
		}
	}
	
	

}
