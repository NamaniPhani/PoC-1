package com.ojas.job;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class JobService {
	@Autowired
	private JobRepository jobRepository;

	@Autowired
	private ExcelHelper excelHelper;

	public boolean createJob(Job job) {
		Job jobSaved = jobRepository.save(job);

		if (jobSaved == null) {
			return false;
		} else {
			return true;

		}
	}

	public Job findByJobId(Integer id) {
		Optional<Job> optional = jobRepository.findById(id);

		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	public List<Job> findJobByType(String type) {

		List<Job> jobs = jobRepository.findByJobType(type);

		return jobs;
	}

	public List<Job> findJobByExperience(Integer experience) {
		List<Job> jobs = jobRepository.findByExperience(experience);

		return jobs;
	}

	public List<Job> findJobByCountry(String country) {
		List<Job> jobs = jobRepository.findByCountry(country);

		return jobs;
	}

	public List<Job> findJobByAvailability(String availability) {
		List<Job> jobs = jobRepository.findByAvailability(availability);

		return jobs;
	}

	public List<Job> findJobByLanguage(String language) {
		List<Job> jobs = jobRepository.findByLanguage(language);

		return jobs;
	}

	public List<Job> findJobBySkill(String skill) {
		List<Job> jobs = jobRepository.findBySkillsContaining(skill);

		return jobs;
	}

	public List<Job> findJobByPayRate(Integer low, Integer high) {
		List<Job> jobs = jobRepository.findByPayRateBetween(low, high);

		return jobs;
	}

	public List<Job> saveAll(MultipartFile file) {
		try {
			List<Job> jobs = excelHelper.excelToTutorials(file.getInputStream());
			List<Job> saveAll = jobRepository.saveAll(jobs);

			return saveAll;
		} catch (IOException e) {

			throw new RuntimeException("fail to store excel data: " + e.getMessage());
		}
	}

}
