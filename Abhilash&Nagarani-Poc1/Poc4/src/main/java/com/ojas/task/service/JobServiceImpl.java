package com.ojas.task.service;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ojas.task.entity.Job;
import com.ojas.task.repo.JobRepo;
import com.ojas.task.response.ExcelHelper;
import com.ojas.task.response.Response;

@Service
public class JobServiceImpl implements JobService {

	private static final Logger log = Logger.getLogger(JobServiceImpl.class);

	@Autowired
	JobRepo repo;

	@Autowired
	Environment env;

	@Value("${pageNo}")
	Integer pageNo; 
	
	@Value("${size}")
	Integer size;

	public Response saveJob(Job j) {
		log.debug("Inside save job method of service class");
		Job job = null;
		Field[] fields = null;
		Response response = null;

		job = repo.save(j);
		response = new Response(job, "Job saved successfully", 200);

		return response;
	}

	@Override
	public Response findById(Integer id) {
		log.debug("Inside findById  method of service class");
		Response response = null;

		Optional<Job> jobsById = null;
		try {

			jobsById = repo.findById(id);
			if (!jobsById.isPresent()) {
				response = new Response(null, "No records found", 409);
			} else
				response = new Response(jobsById, "Records found", 200);

		} catch (Exception e) {
			response = new Response(null, e.getMessage(), 422);
		}
		return response;
	}

	@Override
	public Response findByJobType(String type) {
		log.debug("Inside findByJobType  method of service class");
		List<Job> listOfJobs = null;
		Response response = null;
		Pageable page = null;
		Sort sort = null;

		try {
			
			sort = Sort.by("id").ascending();
			page = PageRequest.of(pageNo, size, sort);

			listOfJobs = repo.findByJobType(type, page);
			if (listOfJobs.isEmpty())
				response = new Response(null, "No records found", 409);
			else
				response = new Response(listOfJobs, "Records found", 200);
		} catch (Exception e) {
			log.debug(e.getMessage());
			response = new Response(null, e.getMessage(), 422);
		}

		return response;
	}

	@Override
	public Response findByExperience(Integer exp) {
		log.debug("Inside findByExperience  method of service class");
		List<Job> listOfJobs = null;
		Response response = null;
		Pageable page = null;
		Sort sort = null;

		try {
			sort = Sort.by("id").ascending();
			page = PageRequest.of(pageNo, size, sort);
			listOfJobs = repo.findByExperience(exp, page);
			if (listOfJobs.isEmpty())
				response = new Response(null, "No records found", 409);
			else
				response = new Response(listOfJobs, "Records found", 200);
		} catch (Exception e) {
			response = new Response(null, e.getMessage(), 422);
		}

		return response;
	}

	@Override
	public Response findByCountry(String country) {
		log.debug("Inside findByCountry  method of service class");
		List<Job> listOfJobs = null;
		Response response = null;
		Pageable page = null;
		Sort sort = null;

		try {
			sort = Sort.by("id").ascending();
			page = PageRequest.of(pageNo, size, sort);
			listOfJobs = repo.findByCountry(country, page);
			if (listOfJobs.isEmpty())
				response = new Response(null, "No records found", 409);
			else
				response = new Response(listOfJobs, "Records found", 200);
		} catch (Exception e) {
			response = new Response(null, e.getMessage(), 422);
		}

		return response;
	}

	@Override
	public Response findByAvailabilityIn(List<String> availability) {
		log.debug("Inside findByAvailability  method of service class");
		List<Job> listOfJobs = null;
		Response response = null;
		Pageable page = null;
		Sort sort = null;

		try {
			sort = Sort.by("id").ascending();
			page = PageRequest.of(pageNo, size, sort);
			listOfJobs = repo.findByAvailabilityIn(availability, page);
			if (listOfJobs.isEmpty())
				response = new Response(null, "No records found", 409);
			else
				response = new Response(listOfJobs, "Records found", 200);
		} catch (Exception e) {
			response = new Response(null, e.getMessage(), 422);
		}

		return response;
	}

	@Override
	public Response findBySkills(String skills) {
		log.debug("Inside findBySkills  method of service class");
		List<Job> listOfJobs = null;
		Response response = null;
		Pageable page = null;
		Sort sort = null;

		try {
			sort = Sort.by("id").ascending();
			page = PageRequest.of(pageNo, size, sort);
			listOfJobs = repo.findBySkillsContains(skills, page);
			if (listOfJobs.isEmpty())
				response = new Response(null, "No records found", 409);
			else
				response = new Response(listOfJobs, "Records found", 200);
		} catch (Exception e) {
			response = new Response(null, e.getMessage(), 422);
		}

		return response;
	}

	@Override
	public Response findByLanguage(String lang) {
		log.debug("Inside findByLanguage  method of service class");
		List<Job> listOfJobs = null;
		Response response = null;
		Pageable page = null;
		Sort sort = null;

		try {
			sort = Sort.by("id").ascending();
			page = PageRequest.of(pageNo, size, sort);
			listOfJobs = repo.findByLanguage(lang, page);
			if (listOfJobs.isEmpty())
				response = new Response(null, "No records found", 409);
			else
				response = new Response(listOfJobs, "Records found", 200);
		} catch (Exception e) {
			response = new Response(null, e.getMessage(), 422);
		}

		return response;
	}

	@Override
	public Response findByPayRateBetween(Integer low, Integer high) {
		log.debug("Inside findByPayRate  method of service class");
		List<Job> listOfJobs = null;
		Response response = null;
		Pageable page = null;
		Sort sort = null;

		try {
			sort = Sort.by("id").ascending();
			page = PageRequest.of(pageNo, size, sort);
			listOfJobs = repo.findByPayRateBetween(low, high, page);
			if (listOfJobs.isEmpty())
				response = new Response(null, "No records found", 409);
			else
				response = new Response(listOfJobs, "Records found", 200);
		} catch (Exception e) {
			response = new Response(null, e.getMessage(), 422);
		}

		return response;
	}

	@Override
	public Response findAll() {
		log.debug("Inside findAll  method of service class");
		Response response = null;
		List<Job> listOfJobs = null;
		Pageable page = null;
		Sort sort = null;
		try {
			sort = Sort.by("id").ascending();
			page = PageRequest.of(pageNo, size, sort);
			listOfJobs = repo.findAll(page).toList();
			if (listOfJobs.isEmpty())
				response = new Response(null, "No records found", 409);
			else
				response = new Response(listOfJobs, "Records found", 200);
		} catch (Exception e) {
			response = new Response(null, e.getMessage(), 409);
		}

		return response;
	}

	public Response saveAll(MultipartFile file) {
		log.debug("Inside Excel upload  method of service class");
		Response response = null;
		List<Job> jobs = null;
		List<Job> jobList = null;
		try {
			jobs = ExcelHelper.excelToDB(file.getInputStream());
			jobList = repo.saveAll(jobs);
			if (jobList.isEmpty()) {
				response = new Response(null, "Records Not Found", 400);
			} else
				response = new Response(jobList, "Records found", 200);

		} catch (IOException e) {
			throw new RuntimeException("fail to store excel data: " + e.getMessage());
		}
		return response;
	}
}
