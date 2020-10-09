package com.emp.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.exception.CustomException;
import com.emp.model.User;
import com.emp.repository.UserRepository;
import com.emp.response.UserResponse;

@Service
public class UserService implements UserServiceInterface {
	private final Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	private UserRepository userRepository;

	UserResponse userResponse = new UserResponse();

	@Override
	public UserResponse save(User user) {
		logger.info("saveOrUpdate service");
		if (user == null || user.getUserId()!=null) {
			logger.error("please enter proper data");
			throw new CustomException("please provide the data");
		} else {
			User save = userRepository.save(user);
			userResponse.setMessage("data saved successfully");
			userResponse.setStatusCode(200);
			userResponse.setUserList(save);
			return userResponse;
		}
}
}
