package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.JobPortal;

@Repository
public interface JobPortalRepository extends JpaRepository<JobPortal, Integer> {
	@Query("SELECT e FROM JobPortal e WHERE e.id = :id")
	 Optional<JobPortal> getById(int id);

	@Query("SELECT e FROM JobPortal e WHERE e.jobType = :name")
	Optional<JobPortal> findByJobType(String name);

	@Query("SELECT e FROM JobPortal e WHERE e.experience = :exp")
	Optional<JobPortal> findByExperience(int exp);

	@Query("SELECT e FROM JobPortal e WHERE e.country = :country")
	Optional<JobPortal> findByCountry(String country);

	@Query("SELECT e FROM JobPortal e WHERE e.availability = :availble")
	Optional<JobPortal> findByAvailbility(String availble);

	@Query("SELECT e FROM JobPortal e WHERE e.language = :language")
	Optional<JobPortal> findByLanguage(String language);

	@Query("SELECT e FROM JobPortal e WHERE e.payRate BETWEEN ?1 AND ?2")
	Optional<JobPortal> findByPayRate(int min, int max);
	
	public Optional<JobPortal> findBySkillsContaining(String skill);

}
