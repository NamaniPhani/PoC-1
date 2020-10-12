package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Job;
import com.example.demo.response.ErrorResponse;
import com.example.demo.response.SuccessResponse;
import com.example.demo.service.JobService;
import com.example.demo.util.Excel;
import com.example.demo.util.Validator;

@RestController
@RequestMapping("poc/job")
public class JobController {
 
	@Autowired
	private JobService jobService;

	Logger log = Logger.getLogger(this.getClass().getName());

	@RequestMapping(value = "/postjob", method = RequestMethod.POST, produces = { "application/json",
			"application/xml" }, consumes = { "application/json", "application/xml" })
	public ResponseEntity<Object> add(@RequestBody Job job) throws Exception {
		System.out.println(job);
		String validation = Validator.validation(job);
		if (validation == null) {
			Job createJob = jobService.createJob(job);
			log.debug("Job data is saved..." + job);
			return new ResponseEntity<Object>(new SuccessResponse(createJob, 200), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(validation, HttpStatus.CONFLICT);
		}
	}

	@RequestMapping(value = "/getById/{id}", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	public ResponseEntity<Object> get(@PathVariable Integer id) {
		try {
			Job job = jobService.getById(id);
			log.debug("request to the get the data....." + job);
			return new ResponseEntity<>(new SuccessResponse(job, 200), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorResponse(e.getMessage(), 409), HttpStatus.CONFLICT);
		}
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	public ResponseEntity<Object> listdata() {
		try {
			List<Job> all = jobService.getAll();
			log.debug("request to the get the All data....." + all);
			return new ResponseEntity<>(new SuccessResponse(all, 200), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorResponse(e.getMessage(), 409), HttpStatus.CONFLICT);
		}
	}

	@RequestMapping(value = "/getBytype/{type}", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	public ResponseEntity<Object> findByJobType(@PathVariable("type") String type) {
		try {
			List<Job> findByJobType = jobService.findByJobType(type);
			log.debug("request to the get the type data....." + findByJobType);
			return new ResponseEntity<>(new SuccessResponse(findByJobType, 200), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorResponse(e.getMessage(), 409), HttpStatus.CONFLICT);
		}
	}

	@RequestMapping(value = "/getByexperience/{exp}", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	public ResponseEntity<Object> findByExperience(@PathVariable("exp") Integer exp) {
		try {
			List<Job> findByExperience = jobService.findByExperience(exp);
			log.debug("request to the get the All Experience Data....." + findByExperience);
			return new ResponseEntity<>(new SuccessResponse(findByExperience, 200), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorResponse(e.getMessage(), 409), HttpStatus.CONFLICT);
		}
	}

	@RequestMapping(value = "/getBycountry/{country}", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	public ResponseEntity<Object> findByCountry(@PathVariable("country") String country) {
		try {
			List<Job> findByCountry = jobService.findByCountry(country);
			log.debug("request to the get the All country Data....." + findByCountry);
			return new ResponseEntity<>(new SuccessResponse(findByCountry, 200), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorResponse(e.getMessage(), 409), HttpStatus.CONFLICT);
		}
	}

	@RequestMapping(value = "/getByAvailability/{availability}", method = RequestMethod.GET, produces = {
			"application/json", "application/xml" })
	public ResponseEntity<Object> findByAvailability(@PathVariable("availability") String availability) {
		try {
			List<Job> findByAvailability = jobService.findByAvailability(availability);
			log.debug("request to the get the All availabilityt Data....." + findByAvailability);
			return new ResponseEntity<>(new SuccessResponse(findByAvailability, 200), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorResponse(e.getMessage(), 409), HttpStatus.CONFLICT);
		}
	}

	@RequestMapping(value = "/getByskills/{skills}", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	public ResponseEntity<Object> findBySkills(@PathVariable("skills") String skills) {
		try {
			List<Job> findBySkills = jobService.findBySkills(skills);
			log.debug("request to the get the All skills Data....." + findBySkills);
			return new ResponseEntity<>(new SuccessResponse(findBySkills, 200), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorResponse(e.getMessage(), 409), HttpStatus.CONFLICT);
		}
	}

	@RequestMapping(value = "/getBylanguage/{language}", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	public ResponseEntity<Object> findByLanguage(@PathVariable("language") String language) {
		try {
			List<Job> findBylanguage = jobService.findByLanguage(language);
			log.debug("request to the get the All language Data....." + findBylanguage);
			return new ResponseEntity<>(new SuccessResponse(findBylanguage, 200), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorResponse(e.getMessage(), 409), HttpStatus.CONFLICT);
		}
	}

	@RequestMapping(value = "/getBypayrate/{id}", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	public ResponseEntity<Object> findByPayRate(@PathVariable("id") Integer id) {
		try {
			List<Job> findByPayRate = jobService.findByPayRate(id);
			log.debug("request to the get the All payrate Data....." + findByPayRate);
			return new ResponseEntity<>(new SuccessResponse(findByPayRate, 200), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorResponse(e.getMessage(), 409), HttpStatus.CONFLICT);
		}
	}

	@PostMapping("/processjobexcel")
	public List<Job> uploadFile(@RequestParam("file") MultipartFile file) {
		if (Excel.hasExcelFormat(file)) {
			try {
				List<Job> list = jobService.saveAll(file);
				log.debug("Excel data saved into a DataBase" + list);
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
 