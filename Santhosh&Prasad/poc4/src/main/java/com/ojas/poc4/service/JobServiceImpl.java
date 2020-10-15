package com.ojas.poc4.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ojas.poc4.exception.CustException;
import com.ojas.poc4.model.JobModel;
import com.ojas.poc4.model.User;
import com.ojas.poc4.repository.JobRepository;
import com.ojas.poc4.util.ExcelFileReader;
import com.ojas.poc4.util.StandardResponse;

/**
 * @author Prasad Rachamalla
 *
 */
@Service
public class JobServiceImpl implements JobService {
	Logger log = LoggerFactory.getLogger(JobServiceImpl.class);
	@Autowired
	JobRepository jobRepository;
	@Value("${file.upload.path}")
	private String UPLOADED_FOLDER;

	@Override
	@Transactional
	public StandardResponse saveJob(JobModel jobModel) {
		log.info("in saveJob method");
		StandardResponse response = null;
		List<JobModel> list = new ArrayList<JobModel>();

		if (jobRepository.findByJobTitle(jobModel.getJobTitle()).size() == 0) {
			User user = new User();
			user.setId(jobModel.getUserInfo().getId());
			user.setName(jobModel.getUserInfo().getName());
			jobModel.setUserInfo(user);
			JobModel jobs = null;
			try {
				jobs = jobRepository.save(jobModel);
			} catch (Exception e) {
				throw new CustException("Save Failed");
			}

			if (null == jobs.getId()) {
				response = new StandardResponse();
				response.setStatusCode(400);
				response.setStatus("failed");
				response.setMessage("Save Failed");
				response.setData(list);
			} else {
				response = new StandardResponse();
				response.setStatusCode(200);
				response.setStatus("success");
				response.setMessage("Data Found");
				list.add(jobs);
				response.setData(list);
			}

		} else {
			log.info("Job Details Already Exist");
			response = new StandardResponse();
			response.setStatusCode(400);
			response.setStatus("duplicatedata");
			response.setMessage("Job Details Already Exist");
			response.setData(list);
		}
		return response;
	}

	@Override
	public StandardResponse findByJob(Long id) {
		log.info("In findByJob method");
		StandardResponse response = null;
		List<JobModel> list = new ArrayList<JobModel>();
		// Pageable sortedById = PageRequest.of(, 3, Sort.by("id"));
		Optional<JobModel> jobs = jobRepository.findById(id);
		if (jobs.isPresent()) {
			response = new StandardResponse();
			response.setStatusCode(200);
			response.setStatus("success");
			response.setMessage("Data Found");
			list.add(jobs.get());
			response.setData(list);

		} else {
			response = new StandardResponse();
			response.setStatusCode(400);
			response.setStatus("failed");
			response.setMessage("No Data Found");
			response.setData(list);
		}

		return response;
	}

	@Override
	public StandardResponse findByJobTitle(String jobTitle) {
		log.info("In findByJobTitle method");
		StandardResponse response = null;
		List<JobModel> jobs = jobRepository.findByJobTitle(jobTitle.trim());
		if (!jobs.isEmpty()) {
			response = new StandardResponse();
			response.setStatusCode(200);
			response.setStatus("success");
			response.setMessage("Data Found");
			response.setData(jobs);

		} else {
			response = new StandardResponse();
			response.setStatusCode(400);
			response.setStatus("failed");
			response.setMessage("No Data Found");
			response.setData(new ArrayList<JobModel>());
		}
		return response;

	}

	@Override
	public StandardResponse findByJobType(String jobType) {
		log.info("In findByJobType method");
		StandardResponse response = null;
		List<JobModel> jobs = jobRepository.findByJobType(jobType.trim());
		if (!jobs.isEmpty()) {
			response = new StandardResponse();
			response.setStatusCode(200);
			response.setStatus("success");
			response.setMessage("Data Found");
			response.setData(jobs);

		} else {
			response = new StandardResponse();
			response.setStatusCode(400);
			response.setStatus("failed");
			response.setMessage("No Data Found");
			response.setData(new ArrayList<JobModel>());
		}
		return response;

	}

	@Override
	public StandardResponse findByExperience(float experience) {
		log.info("In findByExperience method");
		StandardResponse response = null;
		List<JobModel> jobs = jobRepository.findByExperience(experience);
		if (!jobs.isEmpty()) {
			response = new StandardResponse();
			response.setStatusCode(200);
			response.setStatus("success");
			response.setMessage("Data Found");
			response.setData(jobs);

		} else {
			response = new StandardResponse();
			response.setStatusCode(400);
			response.setStatus("failed");
			response.setMessage("No Data Found");
			response.setData(new ArrayList<JobModel>());
		}
		return response;

	}

	@Override
	public StandardResponse findByCountry(String country) {
		StandardResponse response = null;
		List<JobModel> jobs = jobRepository.findByCountry(country.trim());
		if (!jobs.isEmpty()) {
			response = new StandardResponse();
			response.setStatusCode(200);
			response.setStatus("success");
			response.setMessage("Data Found");
			response.setData(jobs);

		} else {
			response = new StandardResponse();
			response.setStatusCode(400);
			response.setStatus("failed");
			response.setMessage("No Data Found");
			response.setData(new ArrayList<JobModel>());
		}
		return response;
	}

	@Override
	public StandardResponse findByAvailability(String availability) {
		log.info("In findByAvailability method");
		List<String> availabilityList = new ArrayList<String>();
		if (availability.trim().contains(",")) {
			String[] strArray = availability.trim().split(",");
			for (String str : strArray) {
				availabilityList.add(str);
			}
		} else {
			availabilityList.add(availability.trim());
		}
		StandardResponse response = null;
		List<JobModel> jobs = jobRepository.findByAvailabilityIn(availabilityList);
		if (!jobs.isEmpty()) {
			response = new StandardResponse();
			response.setStatusCode(200);
			response.setStatus("success");
			response.setMessage("Data Found");
			response.setData(jobs);

		} else {
			response = new StandardResponse();
			response.setStatusCode(400);
			response.setStatus("failed");
			response.setMessage("No Data Found");
			response.setData(new ArrayList<JobModel>());
		}
		return response;

	}

	
	@Override
	public StandardResponse findBySkills(String skills) {
		log.info("In findBySkills method");
		StandardResponse response = null;		
		List<JobModel> jobs = jobRepository.findBySkillsContaining(skills);
		if (!jobs.isEmpty()) {
			response = new StandardResponse();
			response.setStatusCode(200);
			response.setStatus("success");
			response.setMessage("Data Found");
			response.setData(jobs);

		} else {
			response = new StandardResponse();
			response.setStatusCode(400);
			response.setStatus("failed");
			response.setMessage("No Data Found");
			response.setData(new ArrayList<JobModel>());
		}
		return response;
	}

	@Override
	public StandardResponse findByLanguage(String language) {
		log.info("In findByLanguage method");
		StandardResponse response = null;
		List<JobModel> jobs = jobRepository.findByLanguage(language.trim());
		if (!jobs.isEmpty()) {
			response = new StandardResponse();
			response.setStatusCode(200);
			response.setStatus("success");
			response.setMessage("Data Found");
			response.setData(jobs);

		} else {
			response = new StandardResponse();
			response.setStatusCode(400);
			response.setStatus("failed");
			response.setMessage("No Data Found");
			response.setData(new ArrayList<JobModel>());
		}
		return response;

	}

	@Override
	public StandardResponse findByPayRate(int low, int high) {
		log.info("In findByPayRate method");
		StandardResponse response = null;
		List<JobModel> jobs = jobRepository.findByPayRateBetween(low, high);
		if (!jobs.isEmpty()) {
			response = new StandardResponse();
			response.setStatusCode(200);
			response.setStatus("success");
			response.setMessage("Data Found");
			response.setData(jobs);

		} else {
			response = new StandardResponse();
			response.setStatusCode(400);
			response.setStatus("failed");
			response.setMessage("No Data Found");
			response.setData(new ArrayList<JobModel>());
		}
		return response;
	}

	@Override
	public StandardResponse findByAllJobs() {
		log.info("In findByAllJobs method");
		StandardResponse response = null;
		List<JobModel> list = jobRepository.findAll();
		if (list.isEmpty()) {
			response = new StandardResponse();
			response.setStatusCode(400);
			response.setStatus("badrequest");
			response.setMessage("No Data Found");
			response.setData(new ArrayList<JobModel>());
		} else {
			response = new StandardResponse();
			response.setStatusCode(200);
			response.setStatus("success");
			response.setMessage("Data Found");
			response.setData(new ArrayList<JobModel>());
		}

		return response;
	}

	@Override
	public StandardResponse uploadFile(MultipartFile file) {
		log.info("In uploadFile method");
		String extension = file.getOriginalFilename().split("\\.")[1];
		if(!extension.equals("xlsx")) {
			log.info("Please Upload Excel File Only ");
			throw new CustException("Please Upload Excel File Only ");
		}
		
		StandardResponse response = new StandardResponse();

		List<JobModel> jobs = null;
		List<JobModel> jobsList = null;
		try {
			jobs = ExcelFileReader.readExcel(file.getInputStream());
			jobsList = jobRepository.saveAll(jobs);
		} catch (Exception e) {
			log.error("In uploadFile method before save");
			throw new CustException("Unable to find User: " + e.getMessage());
		}
		response.setStatusCode(200);
		response.setStatus("success");
		response.setMessage("Excel Upload");
		response.setData(jobsList);
		return response;

	}

}
