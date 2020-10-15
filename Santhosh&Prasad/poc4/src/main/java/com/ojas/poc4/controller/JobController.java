package com.ojas.poc4.controller;



import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestBody;

import com.ojas.poc4.model.JobModel;
import com.ojas.poc4.service.JobService;
import com.ojas.poc4.util.JobResponse;
import com.ojas.poc4.util.StandardResponse;



/**
 * @author Prasad Rachamalla
 * 
 *
 */
@RestController
@RequestMapping("/job")
public class JobController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	JobService jobService;
		
	
	/**
	 * @param JobModel model
	 * @method createJobModel
	 * This method is used to create job taking input request as JobModel and giving response as JobResponse
	 * 
	 * @return JobResponse 
	 */
	@PostMapping(value="/postjob",produces = { "application/json", "application/xml" },consumes = { "application/json", "application/xml" })
	public ResponseEntity<StandardResponse> createJobModel(@Valid @RequestBody JobModel model){
		log.info("In createJobModel ");
		StandardResponse response =	jobService.saveJob(model);
		return new ResponseEntity<StandardResponse>(response, new HttpHeaders(), HttpStatus.OK);
	}
	
	/**
	 * @param file
	 * @method uploadCsvFile
	 * This method is used to upload file. It taking input request as excel file and giving response as JobResponse
	 * @return JobResponse
	 */
	@PostMapping("/processjobexcel")
	public ResponseEntity<StandardResponse> uploadCsvFile(@RequestParam("file") MultipartFile file){
		log.info("In uploadCsvFile ");
		StandardResponse response = new StandardResponse();
		if(file.isEmpty()) {
			log.info("File is Empty "); 
			return new ResponseEntity<StandardResponse>(response, new HttpHeaders(), HttpStatus.BAD_REQUEST);
		}else {
			log.info("File is not Empty  ");
			response = jobService.uploadFile(file);
		}
		
		return new ResponseEntity<StandardResponse>(response, new HttpHeaders(), HttpStatus.OK);
	}
	
	/**
	 * @param id
	 * @method getJobById
	 * This method is used to get data based on job id and giving response as JobResponse
	 * @return JobResponse
	 */
	@GetMapping(value="/getjob/{id}",produces = { "application/json", "application/xml" })
	public ResponseEntity<StandardResponse> getJobById(@PathVariable("id") Long id){
		log.info("In getJobById ");
		StandardResponse response =	jobService.findByJob(id);
		return new ResponseEntity<StandardResponse>(response, new HttpHeaders(), HttpStatus.ACCEPTED);
	}
	
	/**
	 * @param jobType
	 * @method uploadCsvFile
	 * This method is used to get data based on jobType and giving response as JobResponse
	 * @return JobResponse
	 */
	@GetMapping(value="/getbytype/{type}",produces = { "application/json", "application/xml" })
	public ResponseEntity<StandardResponse> getJobByJobType(@PathVariable("type") String jobType){
		log.info("In getJobByJobType ");
		StandardResponse response =	jobService.findByJobType(jobType);
		return new ResponseEntity<StandardResponse>(response, new HttpHeaders(), HttpStatus.ACCEPTED);
	}
	
	/**
	 * @param exp
	 * @method getJobByExp
	 * This method is used to get data based on exp and giving response as JobResponse
	 * @return JobResponse
	 */
	@GetMapping(value="/getbyexp/{exp}",produces = { "application/json", "application/xml" })
	public ResponseEntity<StandardResponse> getJobByExp(@PathVariable("exp") float exp){
		log.info("In getJobByExp ");
		StandardResponse response =	jobService.findByExperience(exp);
		return new ResponseEntity<StandardResponse>(response, new HttpHeaders(), HttpStatus.ACCEPTED);
	}
	
	/**
	 * @param country
	 * @method getJobBycountry
	 * This method is used to get data based on country and giving response as JobResponse
	 * @return JobResponse
	 */
	@GetMapping(value="/getbycountry/{country}",produces = { "application/json", "application/xml" })
	public ResponseEntity<StandardResponse> getJobBycountry(@PathVariable("country") String country){
		log.info("In getJobBycountry ");
		StandardResponse response =	jobService.findByCountry(country);
		return new ResponseEntity<StandardResponse>(response, new HttpHeaders(), HttpStatus.ACCEPTED);
	}
	
	/**
	 * @param availability
	 * @method getJobByAvailability
	 * This method is used to get data based on availability and giving response as JobResponse
	 * @return JobResponse
	 */
	@GetMapping(value="/getbyavailability/{availability}",produces = { "application/json", "application/xml" })
	public ResponseEntity<StandardResponse> getJobByAvailability(@PathVariable("availability") String availability){
		log.info("In getJobByAvailability ");
		StandardResponse response =	jobService.findByAvailability(availability);
		return new ResponseEntity<StandardResponse>(response, new HttpHeaders(), HttpStatus.ACCEPTED);
	}
	
	/**
	 * @param skills
	 * @method getJobBySkills
	 * This method is used to get data based on skills and giving response as JobResponse
	 * @return JobResponse
	 */
	@GetMapping(value="/getbyskills/{skills}",produces = { "application/json", "application/xml" })
	public ResponseEntity<StandardResponse> getJobBySkills(@PathVariable("skills") String skills){
		log.info("In getJobBySkills ");
		StandardResponse response =	jobService.findBySkills(skills);
		return new ResponseEntity<StandardResponse>(response, new HttpHeaders(), HttpStatus.ACCEPTED);
	}
	
	/**
	 * @param high
	 * @method getJobBySkills
	 * This method is used to get data based on low and high and giving response as JobResponse
	 * @return JobResponse
	 */
	@GetMapping(value="/getbypayrate/{low}/{high}",produces = { "application/json", "application/xml" })
	public ResponseEntity<StandardResponse> getJobByPayRate(@PathVariable("low") int low,@PathVariable("high") int high){
		log.info("In getJobByPayRate ");
		StandardResponse response =	jobService.findByPayRate(low,high);
		
		return new ResponseEntity<StandardResponse>(response, new HttpHeaders(), HttpStatus.ACCEPTED);
	}
	
	/**
	 * @param 
	 * @method getJobBySkills
	 * This method is used to get all records from job and giving response as JobResponse
	 * @return JobResponse
	 */
	@GetMapping(value="/getalljobs",produces = { "application/json", "application/xml" })
	public ResponseEntity<StandardResponse> getAllJobs(){
		log.info("In getAllJobs ");
		StandardResponse response =	jobService.findByAllJobs();
		return new ResponseEntity<StandardResponse>(response, new HttpHeaders(), HttpStatus.ACCEPTED);
	}
	

}
