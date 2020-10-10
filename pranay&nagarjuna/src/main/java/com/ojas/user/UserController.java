package com.ojas.user;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ojas.response.Response;

@RestController
@RequestMapping("/user")
public class UserController {

	private static final Logger logger = LogManager.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@PostMapping(value = "/createuser", consumes = { "application/json", "application/xml" }, produces = {
			"application/json", "application/xml" })
	public ResponseEntity<?> createUser(@RequestBody User user) {
		try {

			if (user == null) {
				logger.info("user object is null");
				Response response = new Response();
				response.setMessage("user object is null");
				response.setStatusCode("422");
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}
			if (user.getUserName() == null || user.getUserName().isEmpty()) {
				logger.info("user object  feilds are null");
				Response response = new Response();
				response.setMessage("userName feild shouldn't null");
				response.setStatusCode("422");
				return new ResponseEntity<>(response, HttpStatus.OK);
			}

			boolean createUser = userService.createUser(user);

			if (!createUser) {
				Response response = new Response();
				response.setMessage("user not created");
				logger.info("user not created");
				response.setStatusCode("200");
				return new ResponseEntity<>(response, HttpStatus.OK);
			}

			else {
				Response response = new Response();
				logger.info("user created successfully");
				response.setMessage("user created successfully");
				response.setStatusCode("200");
				return new ResponseEntity<>(response, HttpStatus.OK);
			}

		}

		catch (DataIntegrityViolationException e) {
			e.printStackTrace();
			logger.info("duplicate username not allowed " + e);
			Response response = new Response();
			response.setMessage("duplicate username ");
			response.setStatusCode("409");
			return new ResponseEntity<>(response, HttpStatus.CONFLICT);
		}

		catch (Exception e) {

			logger.info("exception caught " + e);
			Response response = new Response();
			response.setMessage("Exception Occured");
			response.setStatusCode("409");
			return new ResponseEntity<>(response, HttpStatus.CONFLICT);
		}

	}

}
