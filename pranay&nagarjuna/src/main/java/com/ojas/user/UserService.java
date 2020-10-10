package com.ojas.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public User getUserById(Integer id) {
		Optional<User> optional = userRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}

	}

	public boolean createUser(User user) {

		User userSaved = userRepository.save(user);

		if (userSaved == null) {
			return false;
		} else {
			return true;
		}

	}

}
