package com.ojas.poc4.service;

import org.springframework.web.multipart.MultipartFile;

import com.ojas.poc4.model.JobModel;
import com.ojas.poc4.util.JobResponse;
import com.ojas.poc4.util.StandardResponse;

/**
 * @author Prasad Rachamalla
 *
 */
public interface JobService {
	public StandardResponse saveJob(JobModel jobModel);
	public StandardResponse findByJob(Long id);
	public StandardResponse findByJobTitle(String jobTitle);
	public StandardResponse findByJobType(String jobType);
	public StandardResponse findByExperience(float experience);
	public StandardResponse findByCountry(String country);
	public StandardResponse findByAvailability(String availability);
	public StandardResponse findBySkills(String skills);
	public StandardResponse findByLanguage(String language);
	public StandardResponse findByPayRate(int low,int high);
	public StandardResponse findByAllJobs();
	public StandardResponse uploadFile(MultipartFile file);
}
