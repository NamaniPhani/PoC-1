package com.ojas.task.controller;

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

import com.ojas.task.entity.Job;
import com.ojas.task.response.ExcelHelper;
import com.ojas.task.response.Response;
import com.ojas.task.service.JobService;

@RestController
@RequestMapping("/job")
public class JobController {

	private static final Logger log = Logger.getLogger(JobController.class);

	@Autowired
	private JobService service;

	@PostMapping("/createJob")
	public Response saveJob(@Valid @RequestBody Job job) {
		log.debug("Inside save method of                                                                                                    controller");
		return service.saveJob(job);
	}

	@GetMapping(value = "/getjob/{id}", produces = { "application/json", "application/xml" })
	public Response getById(@PathVariable Integer id) {
		log.debug("Inside getById method of the controller");
		return service.findById(id);
	}

	@GetMapping(value = "/getByType/{type}", produces = { "application/json", "application/xml" })
	public Response getByJobTitle(@PathVariable("type") String type) {
		log.debug("Inside getByType method of the controller");
		return service.findByJobType(type);
	}

	@GetMapping(value = "/getByExp/{exp}", produces = { "application/json", "application/xml" })
	public Response getByExp(@PathVariable Integer exp) {
		log.debug("Inside getByExp method of the controller");
		return service.findByExperience(exp);
	}

	@GetMapping(value = "/getByCountry/{country}", produces = { "application/json", "application/xml" })
	public Response getByCountry(@PathVariable String country) {
		log.debug("Inside getByCountry method of the controller");
		return service.findByCountry(country);
	}

	@GetMapping(value = "/getByAvailability/{avail}", produces = { "application/json", "application/xml" })
	public Response getByAvail(@PathVariable String avail) {
		log.debug("Inside getByAvailability method of the controller");
		String[] availStr = avail.split(",");
		List<String> availList = new ArrayList<>();
		for (String string : availStr) {
			availList.add(string);
		}
		return service.findByAvailabilityIn(availList);
	}

	@GetMapping(value = "/getBySkills/{skills}", produces = { "application/json", "application/xml" })
	public Response getBySkills(@PathVariable String skills) {
		log.debug("Inside getBySkills method of the controller");
		return service.findBySkills(skills);
	}

	@GetMapping(value = "/getByLanguage/{lang}", produces = { "application/json", "application/xml" })
	public Response getByLanguage(@PathVariable String lang) {
		log.debug("Inside getByLanguage method of the controller");
		return service.findByLanguage(lang);
	}

	@GetMapping(value = "/getByPayRate/{low}/{high}", produces = { "application/json", "application/xml" })
	public Response getByPayRate(@PathVariable Integer low, @PathVariable Integer high) {
		log.debug("Inside getByPayRate method of the controller");
		return service.findByPayRateBetween(low, high);
	}

	@GetMapping(value = "/getalljobs", produces = { "application/json", "application/xml" })
	public Response getAllJobs() {
		log.debug("Inside getalljobs method of the controller");
		return service.findAll();
	}

	@PostMapping("/processexcel")
	public Response uploadFile(@RequestParam("file") MultipartFile file) {
		log.debug("Inside uploadFile method of the controller");
		if (ExcelHelper.hasExcelFormat(file)) {
			return service.saveAll(file);
		} else {
			return new Response(null, "Give proper Excel File", 400);
		}

	}

}
