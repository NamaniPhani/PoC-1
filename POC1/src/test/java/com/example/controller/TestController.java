package com.example.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.example.model.JobPortal;
import com.example.model.UserInfo;
import com.example.service.JobPortalServiceImpl;

public class TestController {
	@InjectMocks
	private JobPortalController jobPortalController;
	@Mock
	private JobPortalServiceImpl jobPortalService;

	@Spy
	ResponseEntity<Object> success = new ResponseEntity<>(HttpStatus.OK);
	@Spy
	MultipartFile file;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);

	}

	@Test
	public void saveJob_Ok() throws Exception {
		JobPortal jobPortal = new JobPortal();
		UserInfo userInfo = new UserInfo();
		jobPortal.setId(1);
		jobPortal.setJobTitle("java developer");
		jobPortal.setJobDescription("need to develop the application");
		jobPortal.setCountry("INDIA");
		jobPortal.setState("ts");
		jobPortal.setAvailability("part-time");
		jobPortal.setReplyRate(25);
		jobPortal.setPayRate(20);
		jobPortal.setExperience(7);
		jobPortal.setSkills("java,python");
		jobPortal.setLanguage("english");
		jobPortal.setJobType("testing");
		userInfo.setUsername("ajay");
		jobPortal.setUserInfo(userInfo);
		when(jobPortalService.saveJob(jobPortal)).thenReturn(success);
		ResponseEntity<Object> res = jobPortalController.saveJob(jobPortal);
		assertEquals(res.getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void getByJobId() throws Exception {
		when(jobPortalService.getByJobId(1)).thenReturn(success);
		ResponseEntity<Object> res = jobPortalController.getByJobId(1);
		assertEquals(res.getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void getByJobType() throws Exception {
		when(jobPortalService.getByJobType("Developer")).thenReturn(success);
		ResponseEntity<Object> res = jobPortalController.getByJobType("Developer");
		assertEquals(res.getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void getByJobExp() throws Exception {
		when(jobPortalService.getByExperience(5)).thenReturn(success);
		ResponseEntity<Object> res = jobPortalController.getByExperience(5);
		assertEquals(res.getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void getByJobCountry() throws Exception {
		when(jobPortalService.getByCountry("IND")).thenReturn(success);
		ResponseEntity<Object> res = jobPortalController.getByCountry("IND");
		assertEquals(res.getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void getByJobAvail() throws Exception {
		when(jobPortalService.getByAvailability("part-time")).thenReturn(success);
		ResponseEntity<Object> res = jobPortalController.getByAvailability("part-time");
		assertEquals(res.getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void getByJobLang() throws Exception {
		when(jobPortalService.getByLanguage("English")).thenReturn(success);
		ResponseEntity<Object> res = jobPortalController.getByLanguage("English");
		assertEquals(res.getStatusCode(), HttpStatus.OK);
	}
	@Test
	public void getByJobSkills() throws Exception {
		when(jobPortalService.getBySkills("java")).thenReturn(success);
		ResponseEntity<Object> res = jobPortalController.getBySkills("java");
		assertEquals(res.getStatusCode(), HttpStatus.OK);
	}
	@Test
	public void getByJobPayrate() throws Exception {
		when(jobPortalService.getByPayRate(10,20)).thenReturn(success);
		ResponseEntity<Object> res = jobPortalController.getByPayRate(10,20);
		assertEquals(res.getStatusCode(), HttpStatus.OK);
	}
	@Test
	public void getAllJobs() throws Exception {
		when(jobPortalService.getAllJobs(0,1)).thenReturn(success);
		ResponseEntity<Object> res = jobPortalController.getAllJobs(0, 1);
		assertEquals(res.getStatusCode(), HttpStatus.OK);
	}
	@Test
	public void uploadFile() throws Exception {
		when(jobPortalService.saveAll(file)).thenReturn(success);
		ResponseEntity<Object> res = jobPortalController.uploadFile(file);
		assertEquals(res.getStatusCode(), HttpStatus.OK);
	}

}
