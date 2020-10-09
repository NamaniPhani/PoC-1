package com.example.service;

import static com.example.exception.Constants.EXCEL_READ_DATA;
import static com.example.exception.Constants.EXCEL_UPLOAD_ONLY;
import static com.example.exception.Constants.GET_ALLJOBS_DATA;
import static com.example.exception.Constants.GET_BY_AVAILABILITY;
import static com.example.exception.Constants.GET_BY_COUNTRY;
import static com.example.exception.Constants.GET_BY_EXPERIENCE;
import static com.example.exception.Constants.GET_BY_JOBID;
import static com.example.exception.Constants.GET_BY_JOBTYPE;
import static com.example.exception.Constants.GET_BY_LANGUAGE;
import static com.example.exception.Constants.GET_BY_PAYRATE;
import static com.example.exception.Constants.GET_BY_SKILLS;
import static com.example.exception.Constants.INVALID_FIELDS;
import static com.example.exception.Constants.INVALID_REQUEST;
import static com.example.exception.Constants.JOB_SAVE;
import static com.example.exception.Constants.RECORD_NOT_FOUND;
import static com.example.exception.Constants.SUCCESS;
import static com.example.exception.Constants.SUCCESS_STATUS;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.Response.Response;
import com.example.component.ExcelHelper;
import com.example.exception.CustomException;
import com.example.model.JobPortal;
import com.example.repository.JobPortalRepository;

@Service
public class JobPortalServiceImpl implements JobPortalService {
	@Autowired
	private JobPortalRepository jobRepo;
	@Autowired
	Response response;
	static Logger log = Logger.getLogger(JobPortalServiceImpl.class.getName());

	@Override
	public ResponseEntity<Object> saveJob(JobPortal job) throws Exception {
		log.debug("Incoming request job service : " + job);

		if (job == null) {
			log.error("Invalid request");

			throw new CustomException(INVALID_REQUEST);
		}

		if ((job.getJobType() == null || job.getJobType().isEmpty())
				|| (job.getJobTitle() == null || job.getJobTitle().isEmpty()) || job.getExperience() == null
				|| (job.getAvailability() == null || job.getAvailability().isEmpty())
				|| (job.getJobDescription() == null || job.getJobDescription().isEmpty()) || job.getPayRate() == null
				|| (job.getCountry() == null || job.getCountry().isEmpty())
				|| (job.getLanguage() == null || job.getLanguage().isEmpty())
				|| (job.getState() == null || job.getState().isEmpty()) || (job.getReplyRate() == null)
				|| (job.getSkills() == null || job.getSkills().isEmpty()) || (job.getUserInfo() == null)) {
			log.error("Fields should not be null");
			throw new CustomException(INVALID_FIELDS);

		}

		JobPortal save = jobRepo.save(job);
		response.setStatuscode(SUCCESS_STATUS);
		response.setStatus(SUCCESS);
		response.setMessage(JOB_SAVE);
		response.setTimestamp(new Date());
		response.setData(save);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> getByJobId(Integer id) throws Exception {
		log.debug("Incoming request job service id method : " + id);
		if (id == null || id == 0) {
			log.error("Invalid request");
			throw new CustomException(INVALID_FIELDS);
		}

		Optional<JobPortal> findById = jobRepo.getById(id);

		if (!findById.isPresent()) {
			log.error("Record not found");
			throw new CustomException(RECORD_NOT_FOUND);
		}

		response.setStatuscode(SUCCESS_STATUS);
		response.setStatus(SUCCESS);
		response.setMessage(GET_BY_JOBID);
		response.setTimestamp(new Date());
		response.setData(findById);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> getByJobType(String jobType) throws Exception {
		log.debug("Incoming request job service type method : " + jobType);

		if (jobType == null || jobType.isEmpty()) {
			log.error("Invalid request");
			throw new CustomException(INVALID_FIELDS);
		}
		Optional<JobPortal> findByJobType = jobRepo.findByJobType(jobType);
		if (!findByJobType.isPresent()) {
			log.error("Record not found");
			throw new CustomException(RECORD_NOT_FOUND);
		}
		response.setStatuscode(SUCCESS_STATUS);
		response.setStatus(SUCCESS);
		response.setMessage(GET_BY_JOBTYPE);
		response.setTimestamp(new Date());
		response.setData(findByJobType);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> getByExperience(Integer experience) throws Exception {
		log.debug("Incoming request job service experience method : " + experience);

		if (experience == 0 || experience == null) {
			log.error("Invalid request");
			throw new CustomException(INVALID_FIELDS);
		}
		Optional<JobPortal> findByExperience = jobRepo.findByExperience(experience);
		if (!findByExperience.isPresent()) {
			log.error("Record not found");
			throw new CustomException(RECORD_NOT_FOUND);
		}
		response.setStatuscode(SUCCESS_STATUS);
		response.setStatus(SUCCESS);
		response.setMessage(GET_BY_EXPERIENCE);
		response.setTimestamp(new Date());
		response.setData(findByExperience);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> getByCountry(String country) throws Exception {
		log.debug("Incoming request job service country method : " + country);

		if (country == null || country.isEmpty()) {
			log.error("Invalid request");
			throw new CustomException(INVALID_FIELDS);
		}
		Optional<JobPortal> findByCountry = jobRepo.findByCountry(country);
		if (!findByCountry.isPresent()) {
			log.error("Record not found");
			throw new CustomException(RECORD_NOT_FOUND);
		}
		response.setStatuscode(SUCCESS_STATUS);
		response.setStatus(SUCCESS);
		response.setMessage(GET_BY_COUNTRY);
		response.setTimestamp(new Date());
		response.setData(findByCountry);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> getByAvailability(String availability) throws Exception {
		log.debug("Incoming request job service availability method : " + availability);
		if (availability == null || availability.isEmpty()) {
			log.error("Invalid request");
			throw new CustomException(INVALID_FIELDS);
		}
		Optional<JobPortal> findByAvailability = jobRepo.findByAvailbility(availability);
		if (!findByAvailability.isPresent()) {
			log.error("Record not found");
			throw new CustomException(RECORD_NOT_FOUND);
		}
		response.setStatuscode(SUCCESS_STATUS);
		response.setStatus(SUCCESS);
		response.setMessage(GET_BY_AVAILABILITY);
		response.setTimestamp(new Date());
		response.setData(findByAvailability);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> getByLanguage(String language) throws Exception {
		log.debug("Incoming request job service language method : " + language);

		if (language == null || language.isEmpty()) {
			log.error("Invalid request");
			throw new CustomException(INVALID_FIELDS);
		}
		Optional<JobPortal> findByLanguage = jobRepo.findByLanguage(language);
		if (!findByLanguage.isPresent()) {
			log.error("Record not found");
			throw new CustomException(RECORD_NOT_FOUND);
		}
		response.setStatuscode(SUCCESS_STATUS);
		response.setStatus(SUCCESS);
		response.setMessage(GET_BY_LANGUAGE);
		response.setTimestamp(new Date());
		response.setData(findByLanguage);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> getBySkills(String skills) throws Exception {
		log.debug("Incoming request job service skills method : " + skills);
		if (skills == null || skills.isEmpty()) {
			log.error("Invalid request");
			throw new CustomException(INVALID_FIELDS);
		}
		Optional<JobPortal> findBySkills = jobRepo.findBySkillsContaining(skills);
		if (!findBySkills.isPresent()) {
			log.error("Record not found");
			throw new CustomException(RECORD_NOT_FOUND);
		}
		response.setStatuscode(SUCCESS_STATUS);
		response.setStatus(SUCCESS);
		response.setMessage(GET_BY_SKILLS);
		response.setTimestamp(new Date());
		response.setData(findBySkills);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> getByPayRate(int low, int high) throws Exception {
		log.debug("Incoming request job service payrate method : " + low + high);
		Optional<JobPortal> findByPayRate = jobRepo.findByPayRate(low, high);
		if (!findByPayRate.isPresent()) {
			log.error("Record not found");
			throw new CustomException(RECORD_NOT_FOUND);
		}
		response.setStatuscode(SUCCESS_STATUS);
		response.setStatus(SUCCESS);
		response.setMessage(GET_BY_PAYRATE);
		response.setTimestamp(new Date());
		response.setData(findByPayRate);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> getAllJobs(int pageNo, int pageSize) throws Exception {
		Pageable paging = PageRequest.of(pageNo, pageSize);
		log.debug("Incoming request job service getalljob method ");
		List<JobPortal> findAllJobs = jobRepo.findAll(paging).toList();
		if (!findAllJobs.isEmpty()) {
			log.error("Record not found");
			throw new CustomException(RECORD_NOT_FOUND);
		}
		response.setStatuscode(SUCCESS_STATUS);
		response.setStatus(SUCCESS);
		response.setMessage(GET_ALLJOBS_DATA);
		response.setTimestamp(new Date());
		response.setData(findAllJobs);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	public ResponseEntity<Object> saveAll(MultipartFile file) throws CustomException {
		try {
			String extension = file.getOriginalFilename().split("\\.")[1];
			if (!extension.equals("xlsx")) {
				log.info("Please Upload Excel File Only ");
				throw new CustomException(EXCEL_UPLOAD_ONLY);
			}
			List<JobPortal> jobs = ExcelHelper.excelToTutorials(file.getInputStream());
			List<JobPortal> saveAll = jobRepo.saveAll(jobs);
			response.setStatuscode(SUCCESS_STATUS);
			response.setStatus(SUCCESS);
			response.setMessage(EXCEL_READ_DATA);
			response.setTimestamp(new Date());
			response.setData(saveAll);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (IOException e) {
			log.error("Exception caught in upload file method in service");
			throw new RuntimeException("fail to store excel data: " + e.getMessage());
		}
	}

}
