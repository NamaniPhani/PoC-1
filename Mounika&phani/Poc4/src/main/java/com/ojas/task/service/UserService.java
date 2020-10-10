package com.ojas.task.service;

import com.ojas.task.entity.User;

public interface UserService {
	
	public User save(User user);

	public User findByUserName(String name);
}
