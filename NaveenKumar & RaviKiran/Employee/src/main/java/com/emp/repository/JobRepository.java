package com.emp.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import com.emp.model.Job;

public interface JobRepository extends JpaRepository<Job, Integer> {
	
	public List<Job> findJobByJobType(String jobType);

	public List<Job> findJobByExperience(Float experience);

	public List<Job> findJobByCountry(String country);
	

	public List<Job> findByAvailabilityIn(List<String> availability);

	public List<Job> findBySkills(String skills);

	public List<Job> findJobByLanguage(String language);

	public List<Job> findJobByPayRateBetween(Integer low, Integer high);

}
