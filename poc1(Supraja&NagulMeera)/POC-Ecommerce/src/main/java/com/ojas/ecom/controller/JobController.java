package com.ojas.ecom.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ojas.ecom.model.ExcelHelper;
import com.ojas.ecom.model.Job;
import com.ojas.ecom.service.JobServiceImpl;

@RequestMapping("/job")
@RestController
public class JobController {
	@Autowired
	private JobServiceImpl jobService;

	Logger logger = Logger.getLogger(this.getClass());

	@PostMapping(value = "/createjob", produces = { "application/json", "application/xml" }, consumes = {
			"application/json", "application/xml" })

	public ResponseEntity<Object> saveJob(@Valid @RequestBody Job job)
			throws IllegalArgumentException, IllegalAccessException {
		logger.debug("data coming into controller");
		return jobService.saveJob(job);
	}

	@GetMapping(value = "/getById/{id}", produces = { "application/json", "application/xml" })
	public ResponseEntity<Object> getById(@PathVariable Integer id) {
		logger.error("please provide id");
		return jobService.getById(id);
	}

	@GetMapping(value = "/getByJobType/{type}", produces = { "application/json", "application/xml" })
	public ResponseEntity<Object> getByJobTpe(@PathVariable String type) {
		logger.error("please provide job type");
		return jobService.getByJobType(type);

	}

	@GetMapping(value = "/getByExperience/{experience}", produces = { "application/json", "application/xml" })
	public ResponseEntity<Object> getByExperience(@PathVariable Integer experience) {
		logger.error("please provide experince");
		return jobService.findByExperience(experience);
	}

	@GetMapping(value = "/getByCountry/{country}", produces = { "application/json", "application/xml" })
	public ResponseEntity<Object> getByCountry(@PathVariable String country) {
		logger.error("please provide country");
		return jobService.findByCountry(country);
	}

	@GetMapping(value = "/getByAvailability/{availability}", produces = { "application/json", "application/xml" })
	public ResponseEntity<Object> getByAvailability(@PathVariable String availability) {
		logger.error("please provide availability");
		return jobService.findByAvailability(availability);
	}

	@GetMapping(value = "/getBySkills/{skills}", produces = { "application/json", "application/xml" })
	public ResponseEntity<Object> getBySkills(@PathVariable String skills) {
		logger.error("please provide skills");
		return jobService.findBySkills(skills);
	}

	@GetMapping(value = "/getByLanguage/{language}", produces = { "application/json", "application/xml" })
	public ResponseEntity<Object> getByLanguage(@PathVariable String language) {
		logger.error("please provide language");
		return jobService.findByLanguage(language);
	}

	@GetMapping(value = "/getByPayRate/{low}/{high}", produces = { "application/json", "application/xml" })
	public ResponseEntity<Object> getBypayRate(@PathVariable Integer low, @PathVariable Integer high) {
		logger.error("please provide payrate");
		return new ResponseEntity<Object>(jobService.findByPayRateBetween(low, high), HttpStatus.OK);
	}

	@GetMapping(value = "/getAllJobs", produces = { "application/json", "application/xml" })
	public List<Job> getAllJobs() {
		return jobService.findJobs();

	}

	@PostMapping("/processexcel")
	public List<Job> uploadFile(@RequestParam("file") MultipartFile file) {

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
