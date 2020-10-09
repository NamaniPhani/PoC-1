package com.ojas.task.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ojas.task.entity.Job;

public interface JobRepo extends JpaRepository<Job, Integer>{

	public Optional<Job> findById(Integer id);
	
	public List<Job> findByJobType(String type,Pageable page);
	
	public List<Job> findByExperience(Integer exp,Pageable page);
	
	public List<Job> findByCountry(String country,Pageable page);
	
	public List<Job> findByAvailabilityIn(List<String> availability,Pageable page);
	
	public List<Job> findBySkillsContains(String skills,Pageable page);
	
	public List<Job> findByLanguage(String lang,Pageable page);
	
	public List<Job> findByPayRateBetween(Integer low,Integer high,Pageable page);
}
