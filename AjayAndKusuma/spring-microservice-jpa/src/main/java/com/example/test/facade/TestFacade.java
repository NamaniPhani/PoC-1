package com.example.test.facade;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.example.test.model.JobInfo;
import com.example.test.model.User;

public interface TestFacade {
	public ResponseEntity<Object> saveUser(User user);

	public ResponseEntity<Object> saveJob(JobInfo jobInfo);

	public ResponseEntity<Object> getJobById(Integer id);

	public ResponseEntity<Object> getJobByType(String jobType);

	public ResponseEntity<Object> getJobByExperience(String experience);

	public ResponseEntity<Object> getJobByCountry(String country);

	public ResponseEntity<Object> getJobByAvailability(String availability);

	public ResponseEntity<Object> getJobBySkills(String skills);

	public ResponseEntity<Object> getJobByLanguage(String language);

	public ResponseEntity<Object> getJobByPayrate(Integer low, Integer high);

	public List<JobInfo> saveAll(MultipartFile file);

}
