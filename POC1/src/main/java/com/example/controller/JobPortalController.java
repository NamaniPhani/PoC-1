package com.example.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.exception.CustomException;
import com.example.model.JobPortal;
import com.example.service.JobPortalServiceImpl;

@RestController
@RequestMapping("/job")
public class JobPortalController {
	@Autowired
	private JobPortalServiceImpl jobPortalService;

	private static final Logger log = Logger.getLogger(JobPortalController.class.getName());

	@PostMapping(value = "/postjob", produces = { "application/json", "application/xml" }, consumes = {
			"application/xml", "application/json" })
	public ResponseEntity<Object> saveJob(@RequestBody JobPortal jobReq) throws Exception {
		log.debug("Incoming request job controller : " + jobReq);
		return jobPortalService.saveJob(jobReq);
	}
	

	@GetMapping(value = "/getjob/{id}", produces = { "application/json", "application/xml" })
	public ResponseEntity<Object> getByJobId(@PathVariable Integer id) throws Exception {
		log.debug("Incoming request jobid method : " + id);
		return jobPortalService.getByJobId(id);
	}

	@GetMapping(value = "/getByType/{name}", produces = { "application/json", "application/xml" })
	public ResponseEntity<Object> getByJobType(@PathVariable("name") String type) throws Exception {
		log.debug("Incoming request type method : " + type);
		return jobPortalService.getByJobType(type);
	}

	@GetMapping(value = "/getByExp/{exp}", produces = { "application/json", "application/xml" })
	public ResponseEntity<Object> getByExperience(@PathVariable Integer exp) throws Exception {
		log.debug("Incoming request experience method : " + exp);
		return jobPortalService.getByExperience(exp);
	}

	@GetMapping(value = "/getByCountry/{country}", produces = { "application/json", "application/xml" })
	public ResponseEntity<Object> getByCountry(@PathVariable("country") String country) throws Exception {
		log.debug("Incoming request country method : " + country);
		return jobPortalService.getByCountry(country);
	}

	@GetMapping(path = "/getByAvailability/{availble}", produces = { "application/json", "application/xml" })
	public ResponseEntity<Object> getByAvailability(@PathVariable("availble") String availability) throws Exception {
		log.debug("Incoming request availability method : " + availability);
		return jobPortalService.getByAvailability(availability);
	}

	@GetMapping(value = "/getByLanguage/{language}", produces = { "application/json", "application/xml" })
	public ResponseEntity<Object> getByLanguage(@PathVariable String language) throws Exception {
		log.debug("Incoming request language method : " + language);
		return jobPortalService.getByLanguage(language);
	}

	@GetMapping(path = "/getBySkills/{skills}", produces = { "application/json", "application/xml" })
	public ResponseEntity<Object> getBySkills(@PathVariable String skills) throws Exception {
		log.debug("Incoming request skills method : " + skills);
		return jobPortalService.getBySkills(skills);
	}
	
	@GetMapping(path = "/getBypayRate/{low}/{high}", produces = { "application/json", "application/xml" })
	public ResponseEntity<Object> getByPayRate(@PathVariable int low, @PathVariable int high) throws Exception {
		log.debug("Incoming request payrate method : " + low + high);
		return jobPortalService.getByPayRate(low, high);
	}

	@GetMapping(path = "/getAllJobs/{pageNo}/{pageSize}", produces = { "application/json", "application/xml" })
	public ResponseEntity<Object> getAllJobs(@PathVariable int pageNo,@PathVariable int pageSize) throws Exception {
		log.debug("Incoming request getalljob method ");
		return jobPortalService.getAllJobs(pageNo, pageSize);
	}

	@PostMapping("/processexcel")
	public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file) throws CustomException {
		log.debug("Incoming request uploadfile method ");
		return jobPortalService.saveAll(file);

	}
}
