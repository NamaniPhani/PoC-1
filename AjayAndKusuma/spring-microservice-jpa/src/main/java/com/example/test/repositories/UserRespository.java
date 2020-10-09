package com.example.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.test.model.User;



@Repository
public interface UserRespository extends JpaRepository<User, Integer> {

	

}
