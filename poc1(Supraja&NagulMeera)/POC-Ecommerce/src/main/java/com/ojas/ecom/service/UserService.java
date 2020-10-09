package com.ojas.ecom.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ojas.ecom.model.User;


@Service
public interface UserService {
	ResponseEntity<Object> saveUser(User user);
}
