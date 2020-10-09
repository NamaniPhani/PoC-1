package com.example.test.controllertestcases;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import com.example.test.controller.TestController;
import com.example.test.facade.TestFacadeImpl;
import com.example.test.model.JobInfo;
import com.example.test.model.User;
import com.example.test.repositories.JobInfoRepository;
import com.example.test.repositories.UserRespository;

public class ControllerTestCases {
	@InjectMocks
	private TestController controller;
	@Mock
	private TestFacadeImpl facadeImpl;
	@Mock
	private UserRespository userRespository;
	@Mock
	private JobInfoRepository jobInfoRepository;

	@Mock
	ResponseEntity<Object> obj = new ResponseEntity<Object>(HttpStatus.OK);
	@Spy
	private User user;

	@Autowired
	private JobInfo jobInfo;
	@Autowired
	private MockMvc mockMvc;

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
//		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
//	@Test(expected = CustomizedResponseEntityExceptionHandler.class)
	public void userSave_Ok() {
		User user = new User();
		user.setId(1);
		user.setUserName("kusuma");
		when(facadeImpl.saveUser(user)).thenReturn(obj);
		ResponseEntity<Object> save = controller.createUser(user);// when(controller.createUser(user)).thenReturn(obj);
		assertNotEquals(save.getStatusCode(), HttpStatus.OK);
	}
	@Test
	public void jobSave_Ok() {
		JobInfo info = new JobInfo();
		info.setId(1);
		info.setCountry("India");
		info.setExperience(5);
		when(facadeImpl.saveJob(info)).thenReturn(obj);
		ResponseEntity<Object> save = controller.createJob(info);// when(controller.createUser(user)).thenReturn(obj);
		assertNotEquals(save.getStatusCode(), HttpStatus.OK);
	}

}
