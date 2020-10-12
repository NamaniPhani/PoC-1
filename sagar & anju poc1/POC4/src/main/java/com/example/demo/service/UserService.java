package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User createUser(User user) {
		return userRepository.save(user); 

	}

	public User getById(Integer id) {
		User user = userRepository.findById(id).get();
		return user;
	}

	public List<User> getAll() {
		List<User> findAll = userRepository.findAll();
		return findAll;
	}
	
//	public Optional<User> checkDuplicate(String userName){
//		Optional<User> findDuplicate = userRepository.findByuserName(userName);
//		return null;
//	}
}
