package com.ojas.poc4.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ojas.poc4.model.User;

/**
 * @author Prasad Rachamalla
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByName(String name);

}
