package com.ojas.ecom.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ojas.ecom.model.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {

	public Optional<Job> findById(Integer id,Pageable page);

	public List<Job> findByJobType(String type, Pageable page);

	public List<Job> findByExperience(Integer experience,Pageable page);

	public List<Job> findByCountry(String country,Pageable page);

	public List<Job> findByAvailability(String availability,Pageable page);

	public List<Job> findBySkills(String skills);

	public List<Job> findByLanguage(String language);

	public List<Job> findByPayRateBetween(Integer low, Integer high);
	


}
