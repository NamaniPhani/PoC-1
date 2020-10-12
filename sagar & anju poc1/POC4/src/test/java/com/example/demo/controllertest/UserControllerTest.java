package com.example.demo.controllertest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.controller.UserController;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.util.Validator;

public class UserControllerTest {

	@InjectMocks
	private UserController userController;

	@Mock
	private UserService userService;

	@Mock
	private UserRepository userRepository;

	@Mock
	User user = new User();

	@Mock
	Validator validator;

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);

	}

	@Test
	public void testSave() {
		user.setId(1);
		user.setUserName("User");
		when(userService.createUser(user)).thenReturn(user);
		ResponseEntity<Object> add = userController.add(user);
		assertEquals(add.getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void testSaveConflict() {
		user.setId(1);
		user.setUserName("user");
		when(userService.createUser(user)).thenThrow(RuntimeException.class);
		ResponseEntity<Object> add = userController.add(user);
		assertEquals(add.getStatusCode(), HttpStatus.UNPROCESSABLE_ENTITY);
	}

//	@Test
//	public void testUserNameisPersent() {
//		user.setUserName("User");
//		when(userRepository.findByuserName(user.getUserName())).thenReturn(Optional.of(user));
//		ResponseEntity<Object> add = userController.add(user);
//		assertEquals(add.getStatusCode(), HttpStatus.CONFLICT);
//	}

	@Test
	public void getById_OK() {
		user.setId(1);
		when(userService.getById(user.getId())).thenReturn(user);
		ResponseEntity<Object> byId = userController.getById(user.getId());
		assertEquals(byId.getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void getByIdBad_Request() {
		user.setId(0);
		when(userService.getById(user.getId())).thenReturn(user);
		ResponseEntity<Object> byId = userController.getById(null);
		assertEquals(byId.getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void list() {
		user.setUserName("user");
		user.setUserName("user1");
		List<User> userlist = new ArrayList<User>();
		userlist.add(user);
		when(userService.getAll()).thenReturn(userlist);
		ResponseEntity<Object> list = userController.list();
		assertEquals(list.getStatusCode(), HttpStatus.ACCEPTED);
	}

	@Test
	public void listBad_Request() {
		user.setUserName(null);
		user.setUserName(null);
		List<User> userlist = new ArrayList<User>();
		userlist.add(user);
		when(userService.getAll()).thenReturn(null);
		ResponseEntity<Object> list = userController.list();
		assertEquals(list.getStatusCode(), HttpStatus.BAD_REQUEST);
	}
}
