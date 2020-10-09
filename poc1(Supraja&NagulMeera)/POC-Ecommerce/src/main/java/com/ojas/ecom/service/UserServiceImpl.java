package com.ojas.ecom.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ojas.ecom.model.User;
import com.ojas.ecom.repository.UserRepository;
import com.ojas.ecom.response.UserResponse;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	Logger logger = Logger.getLogger(this.getClass());

	@Override
	public ResponseEntity<Object> saveUser(User user) {
		logger.debug("data coming into the service class");
		User saveUser = userRepo.save(user);
		UserResponse response = new UserResponse();
		response.setStatusCode("200");
		response.setMessage("User Record saved successfully");
		response.setUserList(saveUser);
		return new ResponseEntity<>(response, HttpStatus.OK);
}
}