package com.poc.service;

import com.poc.model.User;
import com.poc.response.SuccessResponse;
import com.poc.utility.BusinessException;

public interface UserService {

	public SuccessResponse createUser(User user) throws BusinessException;
	
}
