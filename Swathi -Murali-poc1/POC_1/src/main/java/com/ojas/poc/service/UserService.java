package com.ojas.poc.service;

import org.springframework.http.ResponseEntity;

import com.ojas.poc.model.User;

public interface UserService {
	
	public ResponseEntity<Object> saveUser(User user) throws Exception;

}
