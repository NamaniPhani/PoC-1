package com.poc.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.poc.dao.JobDao;
import com.poc.model.Job;
import com.poc.response.SuccessResponse;
import com.poc.utility.ExcelHelper;

@Service
public class JobServiceImpl implements JobService {

	@Autowired
	private JobDao jobDao;
	SuccessResponse successResponse = new SuccessResponse();
	Logger logger = Logger.getLogger(this.getClass());

	@Override
	public SuccessResponse createJob(Job job) {
		logger.debug("incoming request for createJob JobServiceImpl ::::" + job);
		try {
			List<Job> jobList = new ArrayList<Job>();
			Job saveJob = jobDao.save(job);
			logger.debug("response for createJob JobServiceImpl ::::" + saveJob);
			jobList.add(saveJob);
			if (saveJob != null) {
				successResponse.setStatusCode("200");
				successResponse.setStatusMessage("Job created successfully");
				successResponse.setJoblist(jobList);
				return successResponse;
			} else {
				successResponse.setStatusCode("422");
				successResponse.setStatusMessage("failed to create job");
				return successResponse;
			}
		} catch (Exception e) {
			logger.error("error createJob JobServiceImpl ::::" + e.getMessage());
			successResponse.setStatusCode("422");
			successResponse.setStatusMessage(e.getMessage());
			return successResponse;
		}
	}

	@Override
	public SuccessResponse getJobById(int id) {
		logger.debug("incoming request for getJobById JobServiceImpl ::::" + id);
		List<Job> jobList = new ArrayList<>();
		try {
			List<Job> findJobById = jobDao.findJobById(id);
			logger.debug("response for getJobById JobServiceImpl ::::" + findJobById);
			if (findJobById != null) {
				successResponse.setStatusCode("200");
				successResponse.setStatusMessage("record fetched successfully");
				successResponse.setJoblist(findJobById);
				return successResponse;
			} else {
				successResponse.setStatusCode("200");
				successResponse.setStatusMessage("record is not found");
				successResponse.setJoblist(jobList);
				return successResponse;
			}
		} catch (Exception e) {
			logger.error("error getJobById JobServiceImpl ::::" + e.getMessage());
			successResponse.setStatusCode("422");
			successResponse.setStatusMessage(e.getMessage());
			return successResponse;
		}
	}

	@Override
	public SuccessResponse getJobByType(String jobType) {
		logger.debug("incoming request for getJobByType JobServiceImpl ::::" + jobType);
		List<Job> jobList = new ArrayList<>();
		try {
			List<Job> findJobByType = jobDao.findJobByType(jobType);
			logger.debug("response for findJobByType JobServiceImpl ::::" + findJobByType);
			if (findJobByType != null) {
				successResponse.setStatusCode("200");
				successResponse.setStatusMessage("record fetched successfully");
				successResponse.setJoblist(findJobByType);
				return successResponse;
			} else {
				successResponse.setStatusCode("200");
				successResponse.setStatusMessage("record is not found");
				successResponse.setJoblist(jobList);
				return successResponse;
			}
		} catch (Exception e) {
			logger.error("error getJobByType JobServiceImpl ::::" + e.getMessage());
			successResponse.setStatusCode("422");
			successResponse.setStatusMessage(e.getMessage());
			return successResponse;
		}
	}

	@Override
	public SuccessResponse getJobByExp(int exp) {
		logger.debug("incoming request for getJobByExp JobServiceImpl ::::" + exp);
		List<Job> jobList = new ArrayList<>();
		try {
			List<Job> findJobByExp = jobDao.findJobByExp(exp);
			logger.debug("response for getJobByExp JobServiceImpl ::::" + findJobByExp);
			if (findJobByExp != null) {
				successResponse.setStatusCode("200");
				successResponse.setStatusMessage("record fetched successfully");
				successResponse.setJoblist(findJobByExp);
				return successResponse;
			} else {
				successResponse.setStatusCode("200");
				successResponse.setStatusMessage("record is not found");
				successResponse.setJoblist(jobList);
				return successResponse;
			}
		} catch (Exception e) {
			logger.error("error getJobByExp JobServiceImpl ::::" + e.getMessage());
			successResponse.setStatusCode("422");
			successResponse.setStatusMessage(e.getMessage());
			return successResponse;
		}
	}

	@Override
	public SuccessResponse getJobByCountry(String country) {
		logger.debug("incoming request for getJobByCountry JobServiceImpl ::::" + country);
		List<Job> jobList = new ArrayList<>();
		try {
			List<Job> findJobByCountry = jobDao.findJobByCountry(country);
			logger.debug("response for getJobByCountry JobServiceImpl ::::" + findJobByCountry);
			if (findJobByCountry != null) {
				successResponse.setStatusCode("200");
				successResponse.setStatusMessage("record fetched successfully");
				successResponse.setJoblist(findJobByCountry);
				return successResponse;
			} else {
				successResponse.setStatusCode("200");
				successResponse.setStatusMessage("record is not found");
				successResponse.setJoblist(jobList);
				return successResponse;
			}
		} catch (Exception e) {
			logger.error("error getJobByCountry JobServiceImpl ::::" + e.getMessage());
			successResponse.setStatusCode("422");
			successResponse.setStatusMessage(e.getMessage());
			return successResponse;
		}
	}

	@Override
	public SuccessResponse getJobByAvailability(String availability) {
		logger.debug("incoming request for getJobByAvailability JobServiceImpl ::::" + availability);
		List<Job> jobList = new ArrayList<>();
		try {
			List<Job> findJobByAvailability = jobDao.findJobByAvailability(availability);
			logger.debug("response for getJobByAvailability JobServiceImpl ::::" + findJobByAvailability);
			if (findJobByAvailability != null) {
				successResponse.setStatusCode("200");
				successResponse.setStatusMessage("record fetched successfully");
				successResponse.setJoblist(findJobByAvailability);
				return successResponse;
			} else {
				successResponse.setStatusCode("200");
				successResponse.setStatusMessage("record is not found");
				successResponse.setJoblist(jobList);
				return successResponse;
			}
		} catch (Exception e) {
			logger.error("error getJobByAvailability JobServiceImpl ::::" + e.getMessage());
			successResponse.setStatusCode("422");
			successResponse.setStatusMessage(e.getMessage());
			return successResponse;
		}
	}

	@Override
	public SuccessResponse getJobBySkills(String skills) {
		logger.debug("incoming request for getJobBySkills JobServiceImpl ::::" + skills);
		List<Job> jobList = new ArrayList<>();
		try {
			        if(skills.contains(",")) {
			        String[] values = skills.split(",");
			        System.out.println(Arrays.toString(values));
			        for (String string : values) {
			        	jobList = jobDao.findJobBySkills(string); 
					}
			        }
			        else {
			        	jobList = jobDao.findJobBySkills(skills); 

			        }

			//List<Job> findJobBySkills = jobDao.findJobBySkills(skills);
			        System.out.println("job listttt"+jobList);
			logger.debug("response for getJobBySkills JobServiceImpl ::::" + jobList);
			if (jobList != null) {
				successResponse.setStatusCode("200");
				successResponse.setStatusMessage("record fetched successfully");
				successResponse.setJoblist(jobList);
				return successResponse;
			} else {
				successResponse.setStatusCode("200");
				successResponse.setStatusMessage("record is not found");
				successResponse.setJoblist(jobList);
				return successResponse;
			}
		} catch (Exception e) {
			logger.error("error getJobBySkills JobServiceImpl ::::" + e.getMessage());
			successResponse.setStatusCode("422");
			successResponse.setStatusMessage(e.getMessage());
			return successResponse;
		}
	}

	@Override
	public SuccessResponse getJobByLanguage(String language) {
		logger.debug("incoming request for getJobByLanguage JobServiceImpl ::::" + language);
		List<Job> jobList = new ArrayList<>();
		try {
			List<Job> findJobByLanguage = jobDao.findJobByLanguage(language);
			logger.debug("response for getJobByLanguage JobServiceImpl ::::" + findJobByLanguage);
			if (findJobByLanguage != null) {
				successResponse.setStatusCode("200");
				successResponse.setStatusMessage("record fetched successfully");
				successResponse.setJoblist(findJobByLanguage);
				return successResponse;
			} else {
				successResponse.setStatusCode("200");
				successResponse.setStatusMessage("record is not found");
				successResponse.setJoblist(jobList);
				return successResponse;
			}
		} catch (Exception e) {
			logger.error("error getJobByLanguage JobServiceImpl ::::" + e.getMessage());
			successResponse.setStatusCode("422");
			successResponse.setStatusMessage(e.getMessage());
			return successResponse;
		}
	}

	@Override
	public SuccessResponse getJobByPayRate(int low, int high) {
		logger.debug("incoming request for getJobByPayRate JobServiceImpl ::::" + low + " " + high);
		List<Job> jobList = new ArrayList<>();
		try {
			List<Job> findJobByPayRate = jobDao.findJobByPayRate(low, high);
			logger.debug("response for getJobByPayRate JobServiceImpl ::::" + findJobByPayRate);
			if (findJobByPayRate != null) {
				successResponse.setStatusCode("200");
				successResponse.setStatusMessage("record fetched successfully");
				successResponse.setJoblist(findJobByPayRate);
				return successResponse;
			} else {
				successResponse.setStatusCode("200");
				successResponse.setStatusMessage("record is not found");
				successResponse.setJoblist(jobList);
				return successResponse;
			}
		} catch (Exception e) {
			logger.error("error getJobByPayRate JobServiceImpl ::::" + e.getMessage());
			successResponse.setStatusCode("422");
			successResponse.setStatusMessage(e.getMessage());
			return successResponse;
		}
	}

	@Override
	public SuccessResponse getAllJobs() {
		try {
			List<Job> jobList = new ArrayList<>();
			List<Job> findAll = jobDao.findAll();
			logger.debug("response for getAllJobs JobServiceImpl ::::" + findAll);
			if (!findAll.isEmpty() && findAll != null) {
				successResponse.setStatusCode("200");
				successResponse.setStatusMessage("records fetched successfully");
				successResponse.setJoblist(findAll);
				return successResponse;

			} else {
				successResponse.setStatusCode("200");
				successResponse.setStatusMessage("records not found");
				successResponse.setJoblist(jobList);
				return successResponse;
			}

		} catch (Exception e) {
			logger.error("error getAllJobs JobServiceImpl ::::" + e.getMessage());
			successResponse.setStatusCode("422");
			successResponse.setStatusMessage(e.getMessage());
			return successResponse;
		}
	}

	public SuccessResponse save(MultipartFile file) {
		logger.debug("incoming request for save JobServiceImpl ::::" + file);
		try {
			List<Job> jobs = ExcelHelper.excelToJobs(file.getInputStream());
			jobDao.saveAll(jobs);
			successResponse.setStatusCode("200");
			successResponse.setStatusMessage("Data inserted in Database successfully");
			return successResponse;
		} catch (IOException e) {
			logger.error("error save JobServiceImpl ::::" + e.getMessage());
			successResponse.setStatusCode("422");
			successResponse.setStatusMessage(e.getMessage());
			return successResponse;
			//throw new RuntimeException("fail to store excel data: " + e.getMessage());
		}
	}
}
