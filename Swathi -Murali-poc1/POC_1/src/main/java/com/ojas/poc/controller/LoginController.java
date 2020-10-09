package com.ojas.poc.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ojas.poc.exception.Response;
import com.ojas.poc.model.Login;

@RestController
@RequestMapping("/poc/user")
public class LoginController {

	@Autowired
	private AuthenticationManager authManager;

	@PostMapping("/login")
	public ResponseEntity<Object> userLogin(@RequestBody Login login) {
		try {
			String userName = login.getUsername();
			Authentication authenticate = authManager
					.authenticate(new UsernamePasswordAuthenticationToken(userName, login.getPassword()));
			Map<Object, Object> object = new HashMap<>();
			object.put("UserName", userName);
			object.put("Data", authenticate);

			return new ResponseEntity<>(object, HttpStatus.OK);

		} catch (Exception e) {
			Response response = new Response();
			response.setTimestamp(new Date());
			response.setMessage("Invalid Credentials !");
			response.setStatuscode("401");
			return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
		}
	}

}
