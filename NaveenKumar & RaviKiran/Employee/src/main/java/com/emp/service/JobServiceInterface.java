package com.emp.service;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import com.emp.model.Job;
import com.emp.response.JobResponse;
import com.emp.response.PagenationResponse;

public interface JobServiceInterface {
public JobResponse save(Job job);
public JobResponse findJobByJobId(Integer jobId);
public JobResponse findJobByJobType(String jobType);
public JobResponse findJobByExperience(Float experience);
public JobResponse findJobByCountry(String country);

public JobResponse findByAvailabilityIn(String availability);
public JobResponse findBySkills(String skills);
public JobResponse findJobByLanguage(String language);
public JobResponse findJobByPayRate(Integer low, Integer high);
public PagenationResponse findAllJob(PagenationResponse pagenationResponse);
public List<Job> saveAll(MultipartFile file);

}
