package com.ojas.poc4.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ojas.poc4.model.User;
import com.ojas.poc4.repository.UserRepository;
import com.ojas.poc4.util.StandardResponse;
import com.ojas.poc4.util.UserResponse;

/**
 * @author Prasad Rachamalla
 *
 */
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository userRepository;

	@Override
	public StandardResponse saveUser(User user) {
		StandardResponse response = null;
		List<User> list = new ArrayList<User>();
		if(userRepository.findByName(user.getName()).isPresent()) {
			response = new StandardResponse();
			response.setStatusCode(400);
			response.setStatus("duplicatedata");
			response.setMessage("User Details Already Exist");
			response.setData(list);
		}else {
			User userDate = userRepository.save(user);
			
			if(null == userDate.getId()) {
				response = new StandardResponse();
				response.setStatusCode(400);
				response.setStatus("failed");
				response.setMessage("Save Failed");
				response.setData(list);
			}else {
				response = new StandardResponse();
				response.setStatusCode(200);
				response.setStatus("success");
				response.setMessage("Data Found");
				list.add(userDate);
				response.setData(list);				
			}
		}
		return response;
	}
	

}
