package com.example.demo.controllertest;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.demo.model.Job;
import com.example.demo.repository.JobRepository;
import com.example.demo.service.JobService;

public class JobServiceTest {
	
	@InjectMocks
	private JobService jobService;
	
	@Mock
	private JobRepository jobRepository;
	
	@Mock
	Job job = new Job();
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void createJob() {
		job.setCountry("india");
		job.setId(1);
		when(jobRepository.save(job)).thenReturn(job);
		Job createJob = jobService.createJob(job);
	}
	
	@Test
	public void getById() {
		job.setId(1);
		Optional<Job> jobOptional = Optional.ofNullable(job);
		when(jobRepository.findById(job.getId())).thenReturn(jobOptional);
		Job getById = jobService.getById(job.getId());
	}
	
	@Test
	public void getAll() {
		job.setCountry("india");
		job.setExperience(3);
		job.setLanguage("hindi");
		ArrayList<Job> joblist = new ArrayList<Job>();
		joblist.add(job);
		when(jobRepository.findAll()).thenReturn(joblist);
		List<Job> all = jobService.getAll();
	}
	
	@Test
	public void findByJobType() {
		job.setCountry("india");
		job.setExperience(3);
		job.setLanguage("hindi");
		ArrayList<Job> joblist = new ArrayList<Job>();
		joblist.add(job);
		when(jobRepository.findByJobType("india")).thenReturn(joblist);
		List<Job> findByJobType = jobService.findByJobType("india");
	}
	
	@Test
	public void findByExperience() {
		job.setCountry("india");
		job.setExperience(3);
		job.setLanguage("hindi");
		ArrayList<Job> joblist = new ArrayList<Job>();
		joblist.add(job);
		when(jobRepository.findByExperience(3)).thenReturn(joblist);
		List<Job> findByJobType = jobService.findByExperience(3);
	}
	
	@Test
	public void findByCountry() {
		job.setCountry("india");
		job.setExperience(3);
		job.setLanguage("hindi");
		ArrayList<Job> joblist = new ArrayList<Job>();
		joblist.add(job);
		when(jobRepository.findByCountry("india")).thenReturn(joblist);
		List<Job> findByJobType = jobService.findByCountry("india");
	}
	

	@Test
	public void findByAvailability() {
		job.setAvailability("Hi ");
		job.setLanguage("hindi"); 
		ArrayList<Job> joblist = new ArrayList<Job>();
		joblist.add(job);
		when(jobRepository.findByAvailability("Hi ")).thenReturn(joblist);
		List<Job> findByJobType = jobService.findByAvailability("HI");
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
		when(jobRepository.findBySkills("java")).thenReturn(joblist);
		List<Job> findByJobType = jobService.findBySkills("Java");
	}
	
	@Test
	public void findByLanguage() {
		job.setLanguage("hindi");
		ArrayList<Job> joblist = new ArrayList<Job>();
		joblist.add(job);
		when(jobRepository.findByLanguage("Hindi")).thenReturn(joblist);
		List<Job> findByJobType = jobService.findByLanguage("Hindi");
	}
	
	@Test
	public void findByPayRate() {
		job.setPayRate(1);
		ArrayList<Job> joblist = new ArrayList<Job>();
		joblist.add(job);
		when(jobRepository.findByPayRate(1)).thenReturn(joblist);
		List<Job> findByJobType = jobService.findByPayRate(1);
	}
}
