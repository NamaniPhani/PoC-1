package com.ojas.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ojas.task.entity.User;
import com.ojas.task.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepo repo;

	@Override
	public User save(User user) {
		return repo.save(user);
	}

	@Override
	public User findByUserName(String name) {
		return repo.findByUserName(name);
	}

}
