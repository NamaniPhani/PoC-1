package com.ojas.job;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {

	List<Job> findByJobType(String type);

	List<Job> findByExperience(Integer experience);

	List<Job> findByCountry(String country);

	List<Job> findByAvailability(String availability);

	List<Job> findByLanguage(String language);

	List<Job> findBySkillsContaining(String skill);

	List<Job> findByPayRateBetween(Integer low, Integer high);

}
