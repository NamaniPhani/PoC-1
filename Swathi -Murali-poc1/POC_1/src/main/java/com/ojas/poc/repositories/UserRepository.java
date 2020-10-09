package com.ojas.poc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ojas.poc.model.User;

public interface UserRepository  extends JpaRepository<User, Integer>{
	
	 public User findByUsername(String username);

}
