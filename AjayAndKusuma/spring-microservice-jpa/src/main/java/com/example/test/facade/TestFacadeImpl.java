package com.example.test.facade;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.test.exception.InvalidDataException;
import com.example.test.model.JobInfo;
import com.example.test.model.User;
import com.example.test.repositories.JobInfoRepository;
import com.example.test.repositories.UserRespository;
import com.example.test.response.ErrorResponse;
import com.example.test.util.ExcelUpload;

@Service
public class TestFacadeImpl implements TestFacade {
	@Autowired
	private UserRespository userRespository;
	@Autowired
	private JobInfoRepository jobInfoRepository;

	Logger log = Logger.getLogger(this.getClass());
	static final String NO_RECORDS = "No records found";

	public ResponseEntity<Object> saveUser(User user) {

		log.debug("Incoming request to saveUser :" + user);
		try {
			User savedUser = userRespository.save(user);
			return new ResponseEntity<Object>(savedUser, HttpStatus.OK);

		} catch (DataIntegrityViolationException e) {
			ErrorResponse response = new ErrorResponse();
			response.setMessage("User is already exists!");
			response.setStatusCode(400);
			return new ResponseEntity<Object>(response, HttpStatus.UNPROCESSABLE_ENTITY);
		} catch (Exception e) {
			ErrorResponse response = new ErrorResponse();
			response.setMessage(e.getMessage());
			response.setStatusCode(400);
			return new ResponseEntity<Object>(response, HttpStatus.CONFLICT);
		}

	}

	public ResponseEntity<Object> saveJob(JobInfo jobInfo) {
		log.debug("Incoming request to saveJob :" + jobInfo);
		try {

			JobInfo savedJob = jobInfoRepository.save(jobInfo);
			return new ResponseEntity<Object>(savedJob, HttpStatus.OK);
		} catch (Exception e) {
			ErrorResponse response = new ErrorResponse();
			response.setMessage(e.getMessage());
			response.setStatusCode(400);
			return new ResponseEntity<Object>(response, HttpStatus.CONFLICT);

		}

	}

	public ResponseEntity<Object> getAll(Integer pageno, Integer pagesize) {
		Sort sort = null;
		Pageable pageable = null;
		sort = Sort.by("name").ascending();
		pageable = PageRequest.of(pageno, pagesize);
		List<JobInfo> all = jobInfoRepository.findAll(pageable).toList();

//		List<JobInfo> all = jobInfoRepository.findAll();
		if (all.isEmpty()) {
			throw new InvalidDataException(NO_RECORDS);
		}
		return new ResponseEntity<Object>(all, HttpStatus.OK);

	}

	public ResponseEntity<Object> getJobById(Integer id) {
		log.debug("Incoming request to getJobById ");

		if (id == null) {
			throw new InvalidDataException("id can not be null");
		}
		Optional<JobInfo> findById = jobInfoRepository.findById(id);
		if (!findById.isPresent()) {
			throw new InvalidDataException(NO_RECORDS);
		}
		return new ResponseEntity<Object>(findById, HttpStatus.OK);

	}

	public ResponseEntity<Object> getJobByType(String jobType) {
		log.debug("Incoming request to getJobByType " + jobType);

		List<JobInfo> job = jobInfoRepository.findByJobType(jobType);

		if (job.isEmpty()) {
			throw new InvalidDataException(NO_RECORDS);
		}
		return new ResponseEntity<Object>(job, HttpStatus.OK);

	}

	public ResponseEntity<Object> getJobByExperience(String experience) {
		log.debug("Incoming request to getJobByExperience " + experience);

		List<JobInfo> job = jobInfoRepository.findByExperience(experience);
		if (job.isEmpty()) {
			throw new InvalidDataException(NO_RECORDS);
		}
		return new ResponseEntity<Object>(job, HttpStatus.OK);

	}

	public ResponseEntity<Object> getJobByCountry(String country) {
		log.debug("Incoming request to getJobByCountry " + country);

		List<JobInfo> job = jobInfoRepository.findByCountry(country);
		if (job.isEmpty()) {
			throw new InvalidDataException(NO_RECORDS);
		}
		return new ResponseEntity<Object>(job, HttpStatus.OK);

	}

	public ResponseEntity<Object> getJobByAvailability(String availability) {
		log.debug("Incoming request to getJobByAvailability " + availability);

		String[] arrayStr = availability.split(",");
		List<String> ListStr = Arrays.asList(arrayStr);

		List<JobInfo> findByAvailabilityIn = jobInfoRepository.findByAvailabilityIn(ListStr);
		if (findByAvailabilityIn.isEmpty()) {
			throw new InvalidDataException(NO_RECORDS);
		}
		return new ResponseEntity<Object>(findByAvailabilityIn, HttpStatus.OK);

	}

	public ResponseEntity<Object> getJobBySkills(String skills) {
		log.debug("Incoming request to getJobBySkills " + skills);

		List<JobInfo> job = jobInfoRepository.findBySkills(skills);
		if (job.isEmpty()) {
			throw new InvalidDataException(NO_RECORDS);
		}
		return new ResponseEntity<Object>(job, HttpStatus.OK);

	}

	public ResponseEntity<Object> getJobByLanguage(String language) {
		log.debug("Incoming request to getJobByLanguage " + language);

		List<JobInfo> job = jobInfoRepository.findByLanguage(language);
		if (job.isEmpty()) {
			throw new InvalidDataException(NO_RECORDS);
		}
		return new ResponseEntity<Object>(job, HttpStatus.OK);

	}

	public ResponseEntity<Object> getJobByPayrate(Integer low, Integer high) {
		log.debug("Incoming request to getJobByPayrate ");

		if (low > high) {
			throw new InvalidDataException("low can't be higherthan high value");
		}
		List<JobInfo> job = jobInfoRepository.findByPayRateBetween(low, high);
		if (job.isEmpty()) {
			throw new InvalidDataException(NO_RECORDS);
		}
		return new ResponseEntity<Object>(job, HttpStatus.OK);

	}

	public List<JobInfo> saveAll(MultipartFile file) {
		log.debug("Inside Excel upload  method of service class");
		try {
			List<JobInfo> jobs = ExcelUpload.excelToTutorials(file.getInputStream());
			List<JobInfo> saveAll = jobInfoRepository.saveAll(jobs);
			return saveAll;
		} catch (IOException e) {
			throw new RuntimeException("fail to store excel data: " + e.getMessage());
		}
	}


}
