package com.ojas.poc4.service;

import com.ojas.poc4.model.User;
import com.ojas.poc4.util.StandardResponse;
import com.ojas.poc4.util.UserResponse;

/**
 * @author Prasad Rachamalla
 *
 */
public interface UserService {
	public StandardResponse saveUser(User user);
	
}
