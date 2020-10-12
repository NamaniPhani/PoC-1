package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.response.Response;
import com.example.demo.response.SuccessResponse;
import com.example.demo.service.UserService;
import com.example.demo.util.Validator;

@RestController
@RequestMapping("/poc/user")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository userRepository;

	Logger log = Logger.getLogger(this.getClass().getName());

	@RequestMapping(value = "/createuser", method = RequestMethod.POST, produces = { "application/json",
			"application/xml" }, consumes = { "application/json", "application/xml" })
	public ResponseEntity<Object> add(@RequestBody User user) {

		try { 
			String validation = Validator.validation(user); 
 
			if (validation == null) { 
				Optional<User> findByuserName = userRepository.findByuserName(user.getUserName());
				if (findByuserName.isPresent()) {
					Response error = new Response();
					error.setMsg("user already exits this name : " + user.getUserName());
					return new ResponseEntity<>(error, HttpStatus.CONFLICT);
				}
				return new ResponseEntity<Object>(validation, HttpStatus.CONFLICT);
			}
			User createUser = userService.createUser(user);
			log.debug("User data saved in database....." + createUser);
			return new ResponseEntity<>(new SuccessResponse(createUser, 200), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
		}

	}

	@RequestMapping(value = "/getByID/{id}", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	public ResponseEntity<Object> getById(@PathVariable Integer id) {
		try {
			User user = userService.getById(id);
			log.debug("request to the get the data...." + user);
			return new ResponseEntity<>(new SuccessResponse(user, 200), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("unable to get the id", HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public ResponseEntity<Object> list() {
		List<User> all = userService.getAll();
		if (all != null) {
			return new ResponseEntity<Object>(all, HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<Object>("unable to get the all data", HttpStatus.BAD_REQUEST);
	}

}
