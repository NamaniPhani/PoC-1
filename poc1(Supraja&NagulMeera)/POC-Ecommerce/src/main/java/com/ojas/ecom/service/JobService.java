package com.ojas.ecom.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ojas.ecom.model.Job;

@Service
public interface JobService {

	ResponseEntity<Object> saveJob(Job job);

	public List<Job> findJobs();
	public ResponseEntity<Object> getById(Integer id);

	public ResponseEntity<Object> getByJobType(String type);

	public ResponseEntity<Object> findByExperience(Integer experience);

	public ResponseEntity<Object> findByCountry(String country);

	public ResponseEntity<Object> findByAvailability(String availability);

	public ResponseEntity<Object> findBySkills(String skills);

	public ResponseEntity<Object> findByLanguage(String language);

	public List<Job> findByPayRateBetween(Integer low, Integer high);

}
