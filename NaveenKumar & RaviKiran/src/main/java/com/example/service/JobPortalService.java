package com.example.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.example.exception.CustomException;
import com.example.model.JobPortal;


public interface JobPortalService {

	
public ResponseEntity<Object> saveJob(JobPortal job) throws Exception;
	
	public ResponseEntity<Object> getByJobId(Integer id) throws Exception;
	
	public ResponseEntity<Object> getByJobType(String jobType) throws Exception;
	
	public ResponseEntity<Object> getByExperience(Integer experience) throws Exception;

	public ResponseEntity<Object> getByCountry(String country) throws Exception;
	
	public ResponseEntity<Object> getByAvailability(String availability) throws Exception;
	
	public ResponseEntity<Object> getByLanguage(String language) throws Exception;
	
	public ResponseEntity<Object> getBySkills(String skills) throws Exception;
	
	public ResponseEntity<Object> getByPayRate(int low, int high) throws Exception;
	
	public ResponseEntity<Object> getAllJobs(int PageNo,int pageSize) throws Exception;

	public ResponseEntity<Object> saveAll(MultipartFile file) throws CustomException ;
}
	
