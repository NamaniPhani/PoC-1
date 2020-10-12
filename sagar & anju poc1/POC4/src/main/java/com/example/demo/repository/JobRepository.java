package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Job;

public interface JobRepository extends JpaRepository<Job, Integer> {

	public Optional<Job> findById(Integer id);

	public List<Job> findByJobType(String jobType);

	public List<Job> findByExperience(Integer id);

	public List<Job> findByCountry(String country);

	public List<Job> findByAvailability(String availability);

	public List<Job> findBySkills(String skills);

	public List<Job> findByLanguage(String language);

	public List<Job> findByPayRate(Integer id);

}
