package com.ojas.task.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ojas.task.entity.Job;
import com.ojas.task.response.Response;

public interface JobService {
	
	public Response saveJob(Job job);
	
	public Response findById(Integer id);
	
	public Response findByJobType(String type);
	
	public Response findByExperience(Integer exp);
	
	public Response findByCountry(String country);
	
	public Response findByAvailabilityIn(List<String> availability);
	
	public Response findBySkills(String skills);
	
	public Response findByLanguage(String lang);
	
	public Response findByPayRateBetween(Integer low,Integer high);
	
	public Response findAll();
	
	public Response saveAll(MultipartFile file);
 
}
