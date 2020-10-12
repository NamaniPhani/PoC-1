package com.example.demo.controllertest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.controller.JobController;
import com.example.demo.model.Job;
import com.example.demo.model.User;
import com.example.demo.service.JobService;
import com.example.demo.util.Validator;

public class JobControllerTest {
	 
	@InjectMocks
	private JobController jobController;
	
	@Mock
	private JobService jobService;
	
	@Spy
	Job job = new Job();
	
	@Spy
	User user = new User();
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	
	
	@Test
	public void add() throws Exception {
		job.setId(1);
		job.setJobType("Devloper");
		job.setCountry("india");
		job.setAvailability("availability");
		job.setJobTitle("job");
		job.setJobDescription("Hi");
		job.setState("hyd");
		job.setAvailability("hi");
		job.setReplyRate(1);
		job.setPayRate(3);
		job.setExperience(3);
		job.setLanguage("Hindi");
		Set<String> s = new HashSet<String>(); 
		s.add("java");
		s.add("paython");
		//job.setSkills(s);
		user.setId(1);
		user.setUserName("user");
		job.setUserInfo(user);
		Validator validator = mock(Validator.class);
		when(jobService.createJob(job)).thenReturn(job);
		ResponseEntity<Object> responseEntity = jobController.add(job);
		assertEquals(responseEntity.getStatusCode(),HttpStatus.OK);
	}
	
	@Test
	public void addConflict() throws Exception {
		job.setId(0);
		job.setJobType(null);
		job.setCountry(null);
		job.setAvailability(null);
		job.setJobTitle(null);
		job.setJobDescription(null);
		job.setState(null);
		job.setAvailability(null);
		job.setReplyRate(0);
		job.setPayRate(0);
		job.setExperience(0);
		job.setLanguage(null);
		Set<String> s = new HashSet<String>(); 
		s.add("java");
		s.add("paython");
		job.setSkills(null);
		user.setId(1);
		user.setUserName(null);
		job.setUserInfo(null);
		Validator validator = mock(Validator.class);
		when(jobService.createJob(job)).thenThrow(RuntimeException.class);
		ResponseEntity<Object> responseEntity = jobController.add(job);
		assertEquals(responseEntity.getStatusCode(),HttpStatus.CONFLICT);
	}
	@Test
	public void getByID() {
		job.setId(1);
		when(jobService.getById(job.getId())).thenReturn(job);
		ResponseEntity<Object> responseEntity = jobController.get(job.getId());
		assertEquals(responseEntity.getStatusCode(),HttpStatus.OK);
	}
	 
	@Test
	public void getByIDBad_Request() throws Exception {
		job.setId(0);
		Mockito.when(jobService.getById(job.getId())).thenThrow(Exception.class);
		ResponseEntity<Object> responseEntity = jobController.get(job.getId());
		assertEquals(responseEntity.getStatusCode(),HttpStatus.CONFLICT);
	}
	
	@Test
	public void listdata() {
		job.setId(1);
		job.setCountry("country");
		job.setExperience(3);
		job.setJobTitle("java");
		java.util.List<Job> joblist= new ArrayList<>();
		when(jobService.getAll()).thenReturn(joblist);
		ResponseEntity<Object> listdata = jobController.listdata();
		assertEquals(listdata.getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void listdataConflict() {
		job.setId(1);
		job.setCountry("country");
		job.setExperience(3);
		job.setJobTitle("java");
		java.util.List<Job> joblist= new ArrayList<>();
		when(jobService.getAll()).thenThrow(RuntimeException.class);
		ResponseEntity<Object> listdata = jobController.listdata();
		assertEquals(listdata.getStatusCode(), HttpStatus.CONFLICT);
	}
	
	@Test
	public void findByJobType() {
		job.setJobType("java");
		ArrayList<Job> arrayList = new ArrayList<Job>();
		arrayList.add(job);
		when(jobService.findByJobType("java")).thenReturn(arrayList);
		ResponseEntity<Object> findByJobType = jobController.findByJobType("java");
		assertEquals(findByJobType.getStatusCode(), HttpStatus.OK);
	}
	

	@Test
	public void findByJobTypeBad_Request() {
		job.setJobType(null);
		ArrayList<Job> arrayList = new ArrayList<Job>();
		arrayList.add(null);
		when(jobService.findByJobType("java")).thenThrow(RuntimeException.class);
		ResponseEntity<Object> findByJobType = jobController.findByJobType("java");
		assertEquals(findByJobType.getStatusCode(), HttpStatus.CONFLICT);
	}
	
	@Test
	public void findByExperience() {
		job.setExperience(3);
		ArrayList<Job> arrayList = new ArrayList<Job>();
		arrayList.add(job);
		when(jobService.findByExperience(3)).thenReturn(arrayList);
		ResponseEntity<Object> findByExperience = jobController.findByExperience(3);
		assertEquals(findByExperience.getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void findByExperienceConflict() {
		job.setExperience(null);
		ArrayList<Job> arrayList = new ArrayList<Job>();
		arrayList.add(null);
		when(jobService.findByExperience(3)).thenThrow(RuntimeException.class);
		ResponseEntity<Object> findByExperience = jobController.findByExperience(3);
		assertEquals(findByExperience.getStatusCode(), HttpStatus.CONFLICT);
	}
	
	@Test
	public void findByCountry() {
		job.setCountry("india");
		ArrayList<Job> arrayList = new ArrayList<Job>();
		arrayList.add(job);
		when(jobService.findByCountry("india")).thenReturn(arrayList);
		ResponseEntity<Object> findByCountry = jobController.findByCountry("india");
		assertEquals(findByCountry.getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void findByCountryConflict() {
		job.setCountry(null);
		ArrayList<Job> arrayList = new ArrayList<Job>();
		arrayList.add(null);
		when(jobService.findByCountry("india")).thenThrow(RuntimeException.class);
		ResponseEntity<Object> findByCountry = jobController.findByCountry("india");
		assertEquals(findByCountry.getStatusCode(), HttpStatus.CONFLICT);
	} 
	
	@Test
	public void findByAvailability() {
		job.setAvailability("HI");
		ArrayList<Job> arrayList = new ArrayList<Job>();
		arrayList.add(job);
		when(jobService.findByAvailability("Hi")).thenReturn(arrayList);
		ResponseEntity<Object> findByAvailability = jobController.findByAvailability("Hi");
		assertEquals(findByAvailability.getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void findByAvailabilityConflict() {
		job.setAvailability(null);
		ArrayList<Job> arrayList = new ArrayList<Job>();
		arrayList.add(job);
		when(jobService.findByAvailability("Hi")).thenThrow(RuntimeException.class);
		ResponseEntity<Object> findByAvailability = jobController.findByAvailability("Hi");
		assertEquals(findByAvailability.getStatusCode(), HttpStatus.CONFLICT);
	}
	@Test
	public void findBySkills() {
	job.setId(1);
	job.setExperience(3);
	ArrayList<Job> joblist = new ArrayList<Job>();
	joblist.add(job);
	Set<String> setjoblist = new HashSet<String>();
	setjoblist.add("Java");
	setjoblist.add("python");
	when(jobService.findBySkills("Java")).thenReturn(joblist);
	ResponseEntity<Object> findBySkills = jobController.findBySkills("java");
	assertEquals(findBySkills.getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void findBySkillsConflict() {
	job.setId(0);
	job.setExperience(0);
	ArrayList<Job> joblist = new ArrayList<Job>();
	joblist.add(job);
	Set<String> setjoblist = new HashSet<String>();
	setjoblist.add("java");
	setjoblist.add("paython");
	when(jobService.findBySkills("java")).thenThrow(RuntimeException.class);
	ResponseEntity<Object> findBySkills = jobController.findBySkills("java");
	assertEquals(findBySkills.getStatusCode(), HttpStatus.CONFLICT);
	}
	
	@Test
	public void findByLanguage() {
		job.setLanguage("Hindi");
		ArrayList<Job> arrayList = new ArrayList<Job>();
		arrayList.add(job);
		when(jobService.findByLanguage("Hindi")).thenReturn(arrayList);
		ResponseEntity<Object> findBylanguage = jobController.findByLanguage("Hindi");
		assertEquals(findBylanguage.getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void findByLanguageConflict() {
		job.setLanguage(null);
		ArrayList<Job> arrayList = new ArrayList<Job>();
		arrayList.add(job);
		when(jobService.findByLanguage("Hindi")).thenThrow(RuntimeException.class);
		ResponseEntity<Object> findBylanguage = jobController.findByLanguage("Hindi");
		assertEquals(findBylanguage.getStatusCode(), HttpStatus.CONFLICT);
	}
	

	@Test
	public void findByPayRate() {
		job.setPayRate(3);;
		ArrayList<Job> arrayList = new ArrayList<Job>();
		arrayList.add(job);
		when(jobService.findByPayRate(3)).thenReturn(arrayList);
		ResponseEntity<Object> findByPayrate = jobController.findByPayRate(3);
		assertEquals(findByPayrate.getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void findByPayRateConflict() {
		job.setPayRate(0);
		ArrayList<Job> arrayList = new ArrayList<Job>();
		arrayList.add(job);
		when(jobService.findByPayRate(3)).thenThrow(RuntimeException.class);
		ResponseEntity<Object> findByPayrate = jobController.findByPayRate(3);
		assertEquals(findByPayrate.getStatusCode(), HttpStatus.CONFLICT);
	}
}
