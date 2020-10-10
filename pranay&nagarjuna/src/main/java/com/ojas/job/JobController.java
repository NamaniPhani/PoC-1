package com.ojas.job;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

import com.ojas.exception.RecordNotFoundException;
import com.ojas.response.Response;
import com.ojas.user.User;
import com.ojas.user.UserService;

@RestController
@RequestMapping("/job")
public class JobController {
	@Autowired
	private JobService jobService;

	@Autowired
	private UserService userService;

	private static final Logger logger = LogManager.getLogger(JobController.class);

	@GetMapping(value = "/getByPayRate/{low}/{high}", consumes = { "application/json", "application/xml" }, produces = {
			"application/json", "application/xml" })
	public ResponseEntity<?> getJobByPayRate(@PathVariable("low") Integer low, @PathVariable("high") Integer high) {
		if (low == null || high == null) {
			logger.info(" job pay rate is null");
			Response response = new Response();
			response.setMessage("job payRate shouldn't null");
			response.setStatusCode("422");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}

		List<Job> job = jobService.findJobByPayRate(low, high);
		if (job.isEmpty()) {

			logger.info(" No jobs found with payrate between " + low + " -" + high);
			Response response = new Response();
			response.setMessage("no jobs found with payrate between " + low + " -" + high);
			response.setStatusCode("200");
			return new ResponseEntity<>(response, HttpStatus.OK);
		}

		logger.info(" jobs with   payrate between" + low + " -" + high + " found");
		return new ResponseEntity<>(job, HttpStatus.OK);

	}

	@GetMapping(value = "/getBySkills/{skill}", consumes = { "application/json", "application/xml" }, produces = {
			"application/json", "application/xml" })
	public ResponseEntity<?> getJobBySkill(@PathVariable("skill") String skill) {
		if (skill == null) {
			logger.info(" job skill is null");
			Response response = new Response();
			response.setMessage("job skill shouldn't null");
			response.setStatusCode("422");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}

		List<Job> job = jobService.findJobBySkill(skill);
		if (job.isEmpty()) {

			logger.info(" No jobs found with skill " + skill);
			Response response = new Response();
			response.setMessage("no jobs found with skill " + skill);
			response.setStatusCode("200");
			return new ResponseEntity<>(response, HttpStatus.OK);
		}

		logger.info(" jobs with  " + skill + " found");
		return new ResponseEntity<>(job, HttpStatus.OK);

	}

	@GetMapping(value = "/getByLanguage/{language}", consumes = { "application/json", "application/xml" }, produces = {
			"application/json", "application/xml" })
	public ResponseEntity<?> getJobByLanguage(@PathVariable("language") String language) {
		if (language == null) {
			logger.info(" job language is null");
			Response response = new Response();
			response.setMessage("job language shouldn't null");
			response.setStatusCode("422");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}

		List<Job> job = jobService.findJobByLanguage(language);
		if (job.isEmpty()) {

			logger.info(" No jobs found with language " + language);
			Response response = new Response();
			response.setMessage("no jobs found with language " + language);
			response.setStatusCode("200");
			return new ResponseEntity<>(response, HttpStatus.OK);
		}

		logger.info(" jobs with  " + language + " found");
		return new ResponseEntity<>(job, HttpStatus.OK);

	}

	@GetMapping(value = "/getByAvailability/{availability}", consumes = { "application/json",
			"application/xml" }, produces = { "application/json", "application/xml" })
	public ResponseEntity<?> getJobByAvailability(@PathVariable("availability") String availability) {
		if (availability == null) {
			logger.info(" job availability is null");
			Response response = new Response();
			response.setMessage("job availability shouldn't null");
			response.setStatusCode("422");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}

		List<Job> job = jobService.findJobByAvailability(availability);
		if (job.isEmpty()) {

			logger.info(" No jobs found with availability " + availability);
			Response response = new Response();
			response.setMessage("no jobs found with availability " + availability);
			response.setStatusCode("200");
			return new ResponseEntity<>(response, HttpStatus.OK);
		}

		logger.info(" jobs with  " + availability + " found");
		return new ResponseEntity<>(job, HttpStatus.OK);

	}

	@GetMapping(value = "/getByCountry/{country}", consumes = { "application/json", "application/xml" }, produces = {
			"application/json", "application/xml" })
	public ResponseEntity<?> getJobByExperience(@PathVariable("country") String country) {
		if (country == null) {
			logger.info(" job country is null");
			Response response = new Response();
			response.setMessage("job country shouldn't null");
			response.setStatusCode("422");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}

		List<Job> job = jobService.findJobByCountry(country);
		if (job.isEmpty()) {

			logger.info(" No jobs found with country " + country);
			Response response = new Response();
			response.setMessage("no jobs found with country " + country);
			response.setStatusCode("200");
			return new ResponseEntity<>(response, HttpStatus.OK);
		}

		logger.info(" jobs with  " + country + " found");
		return new ResponseEntity<>(job, HttpStatus.OK);

	}

	@GetMapping(value = "/getByExp/{exp}", consumes = { "application/json", "application/xml" }, produces = {
			"application/json", "application/xml" })
	public ResponseEntity<?> getJobByExperience(@PathVariable("exp") Integer experience) {
		if (experience == null) {
			logger.info(" job experience is null");
			Response response = new Response();
			response.setMessage("job experience shouldn't null");
			response.setStatusCode("422");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}

		List<Job> job = jobService.findJobByExperience(experience);
		if (job.isEmpty()) {

			logger.info(" No jobs found with experience " + experience);
			Response response = new Response();
			response.setMessage("no jobs found with experience " + experience);
			response.setStatusCode("200");
			return new ResponseEntity<>(response, HttpStatus.OK);
		}

		logger.info(" jobs with  " + experience + " found");
		return new ResponseEntity<>(job, HttpStatus.OK);

	}

	@GetMapping(value = "/getByType/{type}", consumes = { "application/json", "application/xml" }, produces = {
			"application/json", "application/xml" })
	public ResponseEntity<?> getJobById(@PathVariable("type") String type) {
		if (type == null) {
			logger.info(" job type is null");
			Response response = new Response();
			response.setMessage("job type shouldn't null");
			response.setStatusCode("422");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}

		List<Job> job = jobService.findJobByType(type);
		if (job.isEmpty()) {

			logger.info(" No jobs found with type " + type);
			Response response = new Response();
			response.setMessage("no jobs found with type " + type);
			response.setStatusCode("200");
			return new ResponseEntity<>(response, HttpStatus.OK);
		}

		logger.info(" job with  " + type + " found");
		return new ResponseEntity<>(job, HttpStatus.OK);

	}

	@GetMapping(value = "/getjob/{id}", consumes = { "application/json", "application/xml" }, produces = {
			"application/json", "application/xml" })
	public ResponseEntity<?> getJobById(@PathVariable("id") Integer id) {
		if (id == null) {
			logger.info(" job id is null");
			Response response = new Response();
			response.setMessage("job id shouldn't null");
			response.setStatusCode("422");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}

		Job job = jobService.findByJobId(id);
		if (job == null) {

			logger.info(" No jobs found with id " + id);
			Response response = new Response();
			response.setMessage("no jobs found with id " + id);
			response.setStatusCode("200");
			return new ResponseEntity<>(response, HttpStatus.OK);
		}

		logger.info(" job with  " + id + " found");
		return new ResponseEntity<>(job, HttpStatus.OK);

	}

	@PostMapping(value = "/postjob", consumes = { "application/json", "application/xml" }, produces = {
			"application/json", "application/xml" })
	public ResponseEntity<?> createJob(@RequestBody Job job) {

		try {

			if (job == null) {
				logger.info("job object is null");
				Response response = new Response();
				response.setMessage("job object is null");
				response.setStatusCode("422");
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}
			if (job.getJobTitle() == null || job.getJobTitle().isEmpty() || job.getJobDescription() == null
					|| job.getJobDescription().isEmpty() || job.getCountry() == null || job.getCountry().isEmpty()
					|| job.getState() == null || job.getState().isEmpty() || job.getAvailability() == null
					|| job.getAvailability().isEmpty() || job.getReplyRate() == null || job.getPayRate() == null
					|| job.getExperience() == null || job.getSkills() == null || job.getSkills().isEmpty()
					|| job.getLanguage() == null || job.getLanguage().isEmpty() || job.getJobType() == null
					|| job.getJobType().isEmpty() || job.getUserInfo().getUserName().isEmpty()
					|| job.getUserInfo().getUserName() == null || job.getUserInfo().getId() == null) {
				logger.info("job object  feilds are null");
				Response response = new Response();
				response.setMessage("feilds shouldn't null");
				response.setStatusCode("422");
				return new ResponseEntity<>(response, HttpStatus.OK);
			}

			User user = userService.getUserById(job.getUserInfo().getId());

			if (user == null) {
				throw new RecordNotFoundException("user not found");
			}

			boolean createJob = jobService.createJob(job);

			if (!createJob) {
				Response response = new Response();
				response.setMessage("job not created");
				logger.info("job not created");
				response.setStatusCode("200");
				return new ResponseEntity<>(response, HttpStatus.OK);
			}

			else {
				Response response = new Response();
				logger.info("job created successfully");
				response.setMessage("job created successfully");
				response.setStatusCode("200");
				return new ResponseEntity<>(response, HttpStatus.OK);
			}

		} catch (RecordNotFoundException e) {
			logger.info("exception caught " + e);
			Response response = new Response();
			response.setMessage("user not found with user id " + job.getUserInfo().getId());
			response.setStatusCode("409");
			return new ResponseEntity<>(response, HttpStatus.CONFLICT);
		}

		catch (Exception e) {
			logger.info("exception caught " + e);
			Response response = new Response();
			response.setMessage("Exception Occured");
			response.setStatusCode("409");
			return new ResponseEntity<>(response, HttpStatus.CONFLICT);
		}

	}

	@PostMapping("/processjobexcel")
	public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {

		if (ExcelHelper.hasExcelFormat(file)) {

			try {
				List<Job> list = jobService.saveAll(file);
				if (list.isEmpty()) {
					Response response = new Response();
					response.setMessage("job not created");
					logger.info("job not created");
					response.setStatusCode("200");
					return new ResponseEntity<>(response, HttpStatus.OK);
				} else {
					Response response = new Response();
					logger.info("job created successfully");
					response.setMessage("job created successfully");
					response.setStatusCode("200");
					return new ResponseEntity<>(response, HttpStatus.OK);
				}

			} catch (RecordNotFoundException e) {
				logger.info("exception caught " + e);
				Response response = new Response();
				response.setMessage("user not found");
				response.setStatusCode("409");
				return new ResponseEntity<>(response, HttpStatus.CONFLICT);
			}

			catch (Exception e) {
				logger.info("exception caught " + e);
				Response response = new Response();
				response.setMessage("Exception Occured ");
				response.setStatusCode("409");
				return new ResponseEntity<>(response, HttpStatus.CONFLICT);

			}
		} else {
			logger.info("not in excel format");
			Response response = new Response();
			response.setMessage("Not in excel format ");
			response.setStatusCode("200");
			return new ResponseEntity<>(response, HttpStatus.OK);

		}

	}

}
