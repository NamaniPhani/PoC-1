package com.ojas.poc4.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ojas.poc4.model.JobModel;


/**
 * @author Prasad Rachamalla
 *
 */
public interface JobRepository extends JpaRepository<JobModel, Long>{
	 List<JobModel> findByJobTitle(String jobTitle);
	 List<JobModel> findByJobType(String jobType);
	 List<JobModel> findByExperience(float experience);
	 List<JobModel> findByCountry(String country);
	 List<JobModel> findBySkills(String skills);
	 List<JobModel> findByLanguage(String language);
	 List<JobModel> findByPayRateBetween(int low,int high);
	 List<JobModel> findByAvailabilityIn(List<String> availabilitys);	 
	 Optional<JobModel> findByJobTitleAndUserInfo(String jobTitle,Long userId);
	 List<JobModel> findBySkillsContaining(String skills);

	

}
