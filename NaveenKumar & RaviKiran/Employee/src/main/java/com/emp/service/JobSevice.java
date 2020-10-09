package com.emp.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.emp.exception.CustomException;
import com.emp.model.ExcelHelper;
import com.emp.model.Job;
import com.emp.repository.JobRepository;
import com.emp.response.JobResponse;
import com.emp.response.PagenationResponse;

@Service
public class JobSevice implements JobServiceInterface {
	private final Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	private JobRepository jobRepository;

	JobResponse jobResponse = new JobResponse();

	@Override
	public JobResponse save(Job job) {
		logger.info("saveOrUpdate service");
		if (job == null || job.getJobId()==null) {
			logger.error("please enter proper data");
			throw new CustomException("please provide the data");
		} else {
			Job save = jobRepository.save(job);
			jobResponse.setMessage("data saved or updated successfully");
			jobResponse.setStatusCode(200);
			jobResponse.setJobList(save);
			return jobResponse;
		}
	}

	@Override
	public JobResponse findJobByJobId(Integer jobId) {
		logger.info("findJobByJobId service" + jobId);
		if (jobId == null) {
			logger.error("please provide valid job ID");
			throw new CustomException("please provide valid job ID");
		} else {
			Optional<Job> findById = jobRepository.findById(jobId);
			if (!findById.isPresent()) {
				logger.error("Record not found");
				throw new CustomException("Record not found");
			}
			jobResponse.setMessage("data fetched succesfully");
			jobResponse.setStatusCode(200);
			jobResponse.setJobList(findById);
			return jobResponse;
		}
	}

	public JobResponse findJobByJobType(String jobType) {
		logger.info("findJobByJobId service");
		List<Job> findJobByJobType = null;
		if (jobType == null) {
			logger.error("please provide jobtype");
		} else {
			findJobByJobType = jobRepository.findJobByJobType(jobType);
		}
		if (findJobByJobType.isEmpty()) {
			logger.error("Record not found");
			throw new CustomException("Record not found");
		} else {
			jobResponse.setMessage("data fetched succesfully");
			jobResponse.setStatusCode(200);
			jobResponse.setJobList(findJobByJobType);
			return jobResponse;
		}
	}

	@Override
	public JobResponse findJobByExperience(Float experience) {
		logger.info("findJobByExperience service");
		List<Job> findJobByExperience = null;
		if (experience == null) {
			logger.error("please provide jobtype");
		} else {
			findJobByExperience = jobRepository.findJobByExperience(experience);
		}
		if (findJobByExperience.isEmpty()) {
			logger.error("Record not found");
			throw new CustomException("Record not found");
		} else {
			jobResponse.setMessage("data fetched succesfully");
			jobResponse.setStatusCode(200);
			jobResponse.setJobList(findJobByExperience);
			return jobResponse;
		}
	}

	@Override
	public JobResponse findJobByCountry(String country) {
		logger.info("findJobByCountry service");
		List<Job> findJobByCountry = null;
		if (country == null) {
			logger.error("please provide country");
		} else {
			findJobByCountry = jobRepository.findJobByCountry(country);
		}
		if (findJobByCountry.isEmpty()) {
			logger.error("Record not found");
			throw new CustomException("Record not found");
		} else {
			jobResponse.setMessage("data fetched succesfully");
			jobResponse.setStatusCode(200);
			jobResponse.setJobList(findJobByCountry);
			return jobResponse;
		}
	}

	@SuppressWarnings("unused")
	@Override
	public JobResponse findByAvailabilityIn(String availability) {
		List<Job> findByAvailabilityIn = null;
		String[] string = availability.split(",");
		List<String> list = Arrays.asList(string);
		if (availability == null) {
			logger.error("please provide availability");
			throw new CustomException("please provide the availability");
		} else {
			findByAvailabilityIn = jobRepository.findByAvailabilityIn(list);
		}
		if (findByAvailabilityIn.isEmpty()) {
			logger.error("Record not found");
			throw new CustomException("Record not found");
		} else {
			jobResponse.setMessage("data fetched succesfully");
			jobResponse.setStatusCode(200);
			jobResponse.setJobList(findByAvailabilityIn);
			return jobResponse;
		}
	}

	@Override
	public JobResponse findBySkills(String skills) {
		logger.info("findBySkills service");
		List<Job> findBySkills = null;
		if (skills == null) {
			logger.error("please provide skills");
		} else {
			findBySkills = jobRepository.findBySkills(skills);
		}
		if (findBySkills.isEmpty()) {
			logger.error("Record not found");
			throw new CustomException("Record not found");
		} else {
			jobResponse.setMessage("data fetched succesfully");
			jobResponse.setStatusCode(200);
			jobResponse.setJobList(findBySkills);
			return jobResponse;
		}
	}

	@Override
	public JobResponse findJobByLanguage(String language) {
		logger.info("findJobByLanguage service");
		List<Job> findJobByLanguage = null;
		if (language == null) {
			logger.error("please provide language");
		} else {
			findJobByLanguage = jobRepository.findJobByLanguage(language);
		}
		if (findJobByLanguage.isEmpty()) {
			logger.error("Record not found");
			throw new CustomException("Record not found");
		} else {
			jobResponse.setMessage("data fetched succesfully");
			jobResponse.setStatusCode(200);
			jobResponse.setJobList(findJobByLanguage);
			return jobResponse;
		}
	}

	@Override
	public JobResponse findJobByPayRate(Integer low, Integer high) {
		logger.info("findJobByPayRate service");
		List<Job> findJobByPayRateBetween = null;
		if (low == null || high == null) {
			logger.error("please provide low and high");
		} else {
			findJobByPayRateBetween = jobRepository.findJobByPayRateBetween(low, high);
		}
		if (findJobByPayRateBetween.isEmpty()) {
			logger.error("Record not found");
			throw new CustomException("Record not found");
		} else {
			jobResponse.setMessage("data fetched succesfully");
			jobResponse.setStatusCode(200);
			jobResponse.setJobList(findJobByPayRateBetween);
			return jobResponse;
		}
	}

	@Override
	public PagenationResponse findAllJob(PagenationResponse pagenationResponse) {
		logger.info("findAllJob service");
		List<Job> findAll = jobRepository.findAll();
		if (findAll == null) {
			logger.error("Record not found");
			throw new CustomException("records not found");
		} else {
			PageRequest page = PageRequest.of(pagenationResponse.getPageNo(), pagenationResponse.getPageSize(),
					org.springframework.data.domain.Sort.by("jobId"));
			Page<Job> pagefindAll = jobRepository.findAll(page);
			pagenationResponse.setPageNo(pagefindAll.getNumber());
			pagenationResponse.setPageSize(pagefindAll.getSize());
			pagenationResponse.setTotalRecords(pagefindAll.getTotalElements());
			pagenationResponse.setJobList(pagefindAll.getContent());
			pagenationResponse.setMessage("data fetched successfully");
			pagenationResponse.setStatusCode(200);
			return pagenationResponse;
		}
	}

	@Override
	public List<Job> saveAll(MultipartFile file) {
		try {
			List<Job> jobs = ExcelHelper.excel(file.getInputStream());
			List<Job> saveAll = jobRepository.saveAll(jobs);
			
			
			Job job = saveAll.get(0);
			System.out.println(job);
			
			System.out.println(saveAll);
			return saveAll;
		} catch (IOException e) {
			System.out.println("from exception");
			throw new RuntimeException("fail to store excel data: " + e.getMessage());
		}
	}
}
