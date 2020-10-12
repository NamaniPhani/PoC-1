package com.example.demo.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Job;
import com.example.demo.repository.JobRepository;
import com.example.demo.util.Excel;

@Service
public class JobService  {

	@Autowired
	private JobRepository jobRepository;

	public Job createJob(Job job) {
		return jobRepository.save(job);
	}

	public Job getById(Integer id) {
		return jobRepository.findById(id).get();
	}

	public List<Job> getAll() {
		return jobRepository.findAll();
	}

	public List<Job> findByJobType(String jobType) {
		return jobRepository.findByJobType(jobType);
	}

	public List<Job> findByExperience(Integer id) {
		return jobRepository.findByExperience(id);
	}

	public List<Job> findByCountry(String country) {
		return jobRepository.findByCountry(country);
	}

	public List<Job> findByAvailability(String availability) {
		return jobRepository.findByAvailability(availability);
	}

	public List<Job> findBySkills(String skills) {
		return jobRepository.findBySkills(skills);
	}

	public List<Job> findByLanguage(String language) {
		return jobRepository.findByLanguage(language);
	}

	public List<Job> findByPayRate(Integer id) {
		return jobRepository.findByPayRate(id);
	}
	
	public List<Job> saveAll(MultipartFile file) {
        try {
            List<Job> jobs = Excel.excelToTutorials(file.getInputStream());
            System.out.println(jobs);
            List<Job> saveAll = jobRepository.saveAll(jobs);
            System.out.println(saveAll);
            return saveAll;
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }
}
