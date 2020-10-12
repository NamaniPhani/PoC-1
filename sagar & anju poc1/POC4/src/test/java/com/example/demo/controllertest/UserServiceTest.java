package com.example.demo.controllertest;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

public class UserServiceTest {
	
	@InjectMocks
	private UserService userService;
	
	@Mock
	private  UserRepository userRepository;
	
	@Spy
	User user = new User();

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void createUser() {
		when(userRepository.save(user)).thenReturn(user);
		User createUser = userService.createUser(user);
	}

	@Test
	public void getById() {
		user.setId(1);
		Optional<User> userOptional = Optional.ofNullable(user);
		when(userRepository.findById(user.getId())).thenReturn(userOptional);
		User createUser = userService.getById(user.getId());
	}
	
	@Test
	public void FindAll() {
		user.setUserName("user");
		user.setUserName("user1");
		List<User> userlist = new ArrayList<User>();
		userlist.add(user);
		when(userRepository.findAll()).thenReturn(userlist);
		List<User> createUser = userService.getAll();
	}
}
