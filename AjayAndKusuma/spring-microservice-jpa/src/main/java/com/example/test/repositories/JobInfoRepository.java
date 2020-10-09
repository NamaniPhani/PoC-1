package com.example.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.test.model.JobInfo;
import java.lang.String;
import java.util.List;

@Repository
public interface JobInfoRepository extends JpaRepository<JobInfo, Integer> {

	
	List<JobInfo> findByJobType(String jobtype);

	List<JobInfo> findByExperience(String experience);

	List<JobInfo> findByCountry(String country);

//	public JobInfo findByAvailability(String availability);
	List<JobInfo> findByAvailabilityIn(List<String> availability);

	List<JobInfo> findBySkills(String skills);

	List<JobInfo> findByLanguage(String language);

	List<JobInfo> findByPayRateBetween(Integer low, Integer high);

}
