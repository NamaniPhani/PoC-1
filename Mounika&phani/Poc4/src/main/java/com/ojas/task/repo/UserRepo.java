package com.ojas.task.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ojas.task.entity.User;


public interface UserRepo extends JpaRepository<User, Integer>{

	public User findByUserName(String name);
}
