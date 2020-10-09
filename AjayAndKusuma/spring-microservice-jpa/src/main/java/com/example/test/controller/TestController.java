package com.example.test.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.test.facade.TestFacadeImpl;
import com.example.test.model.JobInfo;
import com.example.test.model.User;
import com.example.test.util.ExcelUpload;

@RestController

public class TestController {
	@Autowired
	private TestFacadeImpl testFacadeImpl;
	Logger log = Logger.getLogger(this.getClass());

	// Create New User:
	@PostMapping(value = "/user/createuser", produces = { "application/json", "application/xml" })
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		log.debug("Incoming request to save/update :" + user);
		return testFacadeImpl.saveUser(user);
	}
	// Create New Job:

	@PostMapping(value = "/job/savejobinfo", produces = { "application/json", "application/xml" })
	public ResponseEntity<Object> createJob(@Valid @RequestBody JobInfo info) {
		log.debug("Incoming request to save/update :" + info);
		return testFacadeImpl.saveJob(info);
	}
	// -> Get All Jobs:

	@GetMapping(value = "/job/getalljobs/{pageno}/{pagesize}", produces = { "application/json", "application/xml" })
	public ResponseEntity<Object> getAll(@PathVariable Integer pageno, @PathVariable Integer pagesize) {
		log.info("data is received into controller-getAll");
		return testFacadeImpl.getAll(pageno, pagesize);
	}

	// Get Job by ID:
	@GetMapping(value = "/job/{id}", produces = { "application/json", "application/xml" })
	public ResponseEntity<Object> getJobById(@PathVariable("id") Integer id) {
		log.info("data is received into controller-getJobById");
		return testFacadeImpl.getJobById(id);
	}

	// -> Filter Job by Type:
	@GetMapping(value = "/job/getByType/{type}", produces = { "application/json", "application/xml" })
	public ResponseEntity<Object> getJobByType(@PathVariable("type") String jobType) {
		log.info("data is received into controller-getJobByType");
		return testFacadeImpl.getJobByType(jobType);
	}

	// Filter Job by Experience:
	@GetMapping(value = "/job/getByExp/{experience}", produces = { "application/json", "application/xml" })

	public ResponseEntity<Object> getJobByExperience(@PathVariable("experience") String experience) {
		log.info("data is received into controller-getJobByExperience");
		return testFacadeImpl.getJobByExperience(experience);
	}

	// > Filter Job by Country
	@GetMapping(value = "/job/getByCountry/{country}", produces = { "application/json", "application/xml" })
	public ResponseEntity<Object> getJobByCountry(@PathVariable("country") String country) {
		log.info("data is received into controller-getJobByCountry");
		return testFacadeImpl.getJobByCountry(country);
	}

	// Filter Job by Availability:
	@GetMapping(value = "/job/getByAvailability/{availability}", produces = { "application/json", "application/xml" })
	public ResponseEntity<Object> getJobByAvailability(@PathVariable("availability") String availability) {
		log.info("data is received into controller-getJobByAvailability");
		return testFacadeImpl.getJobByAvailability(availability);
	}

	// Filter Job by Skill
	@GetMapping(value = "/job/getBySkills/{skills}", produces = { "application/json", "application/xml" })
	public ResponseEntity<Object> getJobBySkills(@PathVariable("skills") String skills) {
		log.info("data is received into controller-getJobBySkills-");
		return testFacadeImpl.getJobBySkills(skills);
	}

	// Filter Job by Language:
	@GetMapping(value = "/job/getByLanguage/{language}", produces = { "application/json", "application/xml" })
	public ResponseEntity<Object> getJobByLanguage(@PathVariable("language") String language) {
		log.info("data is received into controller-getJobByLanguage");
		return testFacadeImpl.getJobByLanguage(language);
	}

	// > Filter Job by PayRate:
	@GetMapping(value = "/job/getByPayRate/{low}/{high}", produces = { "application/json", "application/xml" })
	public ResponseEntity<Object> getJobByPayrate(@PathVariable("low") Integer low,
			@PathVariable("high") Integer high) {
		log.info("data is received into controller-getJobByPayrate");
		return testFacadeImpl.getJobByPayrate(low, high);
	}

	@PostMapping("/job/processexcel")
	public List<JobInfo> uploadFile(@RequestParam("file") MultipartFile file) {
		log.debug("Inside uploadFile method of the controller");
		if (ExcelUpload.hasExcelFormat(file)) {
			try {
				List<JobInfo> list = testFacadeImpl.saveAll(file);
				return list;
			} catch (Exception e) {
				e.printStackTrace();
				return new ArrayList<JobInfo>();
			}
		} else {
			System.out.println("not excel");
			return new ArrayList<>();
		}

	}
}
