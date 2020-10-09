package com.emp.controller;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.emp.model.ExcelHelper;
import com.emp.model.Job;
import com.emp.response.JobResponse;
import com.emp.response.PagenationResponse;
import com.emp.service.JobServiceInterface;

@RestController
@RequestMapping("/job")
public class JobController {
	private final Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private JobServiceInterface jobService;

	@PostMapping(value = "/postJob", produces = { "application/json", "application/xml" }, consumes = {
			"application/json", "application/xml" })
	public JobResponse save(/*@Valid */@RequestBody Job job) {
		logger.info("inside save method of job");
		return jobService.save(job);
	}
	
	@GetMapping(value = "/getJobByJobId/{jobId}", produces = { "application/json", "application/xml" })
	public JobResponse findJobByJobId(@PathVariable Integer jobId) {
		logger.info("inside findJobByJobId method of job");
		JobResponse findJobByJobId = jobService.findJobByJobId(jobId);
		return findJobByJobId;
	
	}

	@RequestMapping(value = "/getJobByType/{jobType}", produces = { "application/json", "application/xml" })
	public JobResponse findJobByJobType(@PathVariable String jobType) {
		logger.info("inside findJobByJobType method of job");
		JobResponse findJobByJobType = jobService.findJobByJobType(jobType);
		return findJobByJobType;
		
	}

	@RequestMapping(value = "/getJobByExp/{experience}", produces = { "application/json", "application/xml" })
	public JobResponse findJobByExperience(@PathVariable Float experience) {
		logger.info("inside findJobByExperience method of job");
		JobResponse findJobByExperience = jobService.findJobByExperience(experience);
		return findJobByExperience;
	
	}

	@RequestMapping(value = "/getJobByCountry/{country}", produces = { "application/json", "application/xml" })
	public JobResponse findJobByCountry(@PathVariable String country) {
		logger.info("inside findJobByCountry method of job");
		JobResponse findJobByCountry = jobService.findJobByCountry(country);
		return findJobByCountry;
		
	}

	@RequestMapping(value = "/getByAvailability/{availability}", produces = { "application/json", "application/xml" })
	public JobResponse findByAvailability(@PathVariable String availability) {
		logger.info("inside findByAvailability method of job");
	JobResponse findByAvailabilityIn = jobService.findByAvailabilityIn(availability);
	return findByAvailabilityIn;
	}

	@RequestMapping(value = "/getBySkills/{skills}", produces = { "application/json", "application/xml" })
	public JobResponse findBySkills(@PathVariable String skills) {
		logger.info("inside findBySkills method of job");
		JobResponse findBySkills = jobService.findBySkills(skills);
		return findBySkills;
	}

	@RequestMapping(value = "/getJobByLanguage/{language}", produces = { "application/json", "application/xml" })
	public JobResponse findJobByLanguage(@PathVariable String language) {
		logger.info("inside findJobByLanguage method of job");
		JobResponse findJobByLanguage = jobService.findJobByLanguage(language);
		return findJobByLanguage;
	}

	@RequestMapping(value = "/getJobByPayRate/{low}/{high}", produces = { "application/json", "application/xml" })
	public JobResponse findJobByPayRateBetween(@PathVariable Integer low, @PathVariable Integer high) {
		logger.info("inside findJobByPayRateBetween method of job");
		JobResponse findJobByPayRate = jobService.findJobByPayRate(low, high);
		return findJobByPayRate;
		
	}

	@RequestMapping(value = "/getAllJobs/{pageNo}/{pageSize}", produces = { "application/json", "application/xml" })
	public PagenationResponse findAllJob(PagenationResponse pagenationResponse) {
		logger.info("inside findAllJob method of job");
		PagenationResponse findAllJob = jobService.findAllJob(pagenationResponse);
		return findAllJob;
	}

	@PostMapping("/processJobExcel")
	public List<Job> uploadFile(@RequestParam("file") MultipartFile file) {

		logger.info("inside uploadFile method of job");

		if (ExcelHelper.hasExcelFormat(file)) {

			try {
				List<Job> list = jobService.saveAll(file);
				return list;

			} catch (Exception e) {
				System.out.println(e.getMessage());
				return new ArrayList<Job>();

			}
		} else {
			System.out.println("not excel format");
			return new ArrayList<>();
		}

	}

}
