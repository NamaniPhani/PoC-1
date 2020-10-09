package com.ojas.ecom.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ojas.ecom.customexception.CustomizedException;
import com.ojas.ecom.model.ExcelHelper;
import com.ojas.ecom.model.Job;
import com.ojas.ecom.repository.JobRepository;
import com.ojas.ecom.response.JobResponse;

@Service
public class JobServiceImpl implements JobService {
	@Autowired
	private JobRepository jobRepo;

	@Autowired
	private Environment env;

	Logger logger = Logger.getLogger(this.getClass());

	@Override
	public ResponseEntity<Object> saveJob(Job job) {
		logger.debug("Incoming request job service : " + job);

		Job saveJob = jobRepo.save(job);
		JobResponse response = new JobResponse();
		response.setStatusCode("200");
		response.setMessage("Job Record saved successfully");
		response.setJobList(saveJob);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<Object> getById(Integer id) {
		logger.debug("Request coming in to the job service id method : " + id);

		Optional<Job> findById = jobRepo.findById(id);
		if (!findById.isPresent()) {
			logger.error("Record not found");
			throw new CustomizedException("Record Not Found");
		}
		JobResponse response = new JobResponse();
		response.setStatusCode("200");
		response.setMessage("data fetched succesfully");
		response.setJobList(findById);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> getByJobType(String type) {
		Sort sort = Sort.by("jobTitle").ascending();
		Integer pageNo = Integer.parseInt(env.getProperty("pageNo"));
		Integer pageSize = Integer.parseInt(env.getProperty("pageSize"));
		Pageable page = PageRequest.of(pageNo, pageSize, sort);
		List<Job> findByJobType = jobRepo.findByJobType(type, page);
		if (findByJobType.isEmpty()) {
			logger.error("Record not found");
			throw new CustomizedException("Record Not Found");
		}
		JobResponse response = new JobResponse();
		response.setStatusCode("200");
		response.setMessage("Record fetched successfully");
		response.setJobList(findByJobType);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> findByExperience(Integer experience) {
		Sort sort = Sort.by("jobTitle").ascending();
		Integer pageNo = Integer.parseInt(env.getProperty("pageNo"));
		Integer pageSize = Integer.parseInt(env.getProperty("pageSize"));
		Pageable page = PageRequest.of(pageNo, pageSize, sort);

		List<Job> jobExperience = jobRepo.findByExperience(experience, page);
		if (jobExperience.isEmpty()) {
			logger.error("Record not found");
			throw new CustomizedException("Record Not Found");
		}
		JobResponse response = new JobResponse();
		response.setStatusCode("200");
		response.setMessage("Record fetched successfully");
		response.setJobList(jobExperience);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> findByCountry(String country) {
		Sort sort = Sort.by("jobTitle").ascending();
		Integer pageNo = Integer.parseInt(env.getProperty("pageNo"));
		Integer pageSize = Integer.parseInt(env.getProperty("pageSize"));
		Pageable page = PageRequest.of(pageNo, pageSize, sort);

		List<Job> findByCountry = jobRepo.findByCountry(country, page);
		if (findByCountry.isEmpty()) {
			logger.error("Record not found");
			throw new CustomizedException("Record Not Found");
		}
		JobResponse response = new JobResponse();
		response.setStatusCode("200");
		response.setMessage("Record fetched successfully");
		response.setJobList(findByCountry);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> findByAvailability(String availability) {
		Sort sort = Sort.by("jobTitle").ascending();
		Integer pageNo = Integer.parseInt(env.getProperty("pageNo"));
		Integer pageSize = Integer.parseInt(env.getProperty("pageSize"));
		Pageable page = PageRequest.of(pageNo, pageSize, sort);
		List<Job> findByAvailability = jobRepo.findByAvailability(availability, page);
		if (findByAvailability.isEmpty()) {
			logger.error("Record not found");
			throw new CustomizedException("Record Not Found");
		}
		JobResponse response = new JobResponse();
		response.setStatusCode("200");
		response.setMessage("Record fetched successfully");
		response.setJobList(findByAvailability);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> findBySkills(String skills) {

		List<Job> findBySkills = jobRepo.findBySkills(skills);
		if (findBySkills.isEmpty()) {
			logger.error("Record not found");
			throw new CustomizedException("Record Not Found");
		}
		JobResponse response = new JobResponse();
		response.setStatusCode("200");
		response.setMessage("Record fetched successfully");
		response.setJobList(findBySkills);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> findByLanguage(String language) {

		List<Job> findByLanguage = jobRepo.findByLanguage(language);
		if (findByLanguage.isEmpty()) {
			logger.error("Record not found");
			throw new CustomizedException("Record Not Found");
		}
		JobResponse response = new JobResponse();
		response.setStatusCode("200");
		response.setMessage("Record fetched successfully");
		response.setJobList(findByLanguage);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public List<Job> findByPayRateBetween(Integer low, Integer high) {

		return jobRepo.findByPayRateBetween(low, high);
	}

	@Override
	public List<Job> findJobs() {
		Sort sort = Sort.by("jobTitle").ascending();
		Integer pageNo = Integer.parseInt(env.getProperty("pageNo"));
		Integer pageSize = Integer.parseInt(env.getProperty("pageSize"));
		Pageable page = PageRequest.of(pageNo, pageSize, sort);
		logger.error("get all job details");
		return jobRepo.findAll(page).toList();
	}

	public List<Job> saveAll(MultipartFile file) {
		try {
			List<Job> jobs = ExcelHelper.excelToJob(file.getInputStream());
			List<Job> saveAll = jobRepo.saveAll(jobs);
			System.out.println(saveAll);
			return saveAll;
		} catch (IOException e) {
			System.out.println("from exception");
			throw new RuntimeException("fail to store excel data: " + e.getMessage());
		}
	}
}
