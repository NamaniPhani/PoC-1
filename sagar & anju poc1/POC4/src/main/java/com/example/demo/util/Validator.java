package com.example.demo.util;

import com.example.demo.model.Job;
import com.example.demo.model.User;

public class Validator {

	public static String validation(Job job) {
		if (job.getJobTitle() == null || job.getJobTitle().isEmpty()) {
			return "JobTitle cannot be a null!";
		} else if (job.getJobDescription() == null || job.getJobDescription().isEmpty()) {
			return "JobDescription cannot be a null!";
		} else if (job.getCountry() == null || job.getCountry().isEmpty()) {
			return "Country cannot be a null!";
		} else if (job.getState() == null || job.getState().isEmpty()) {
			return "State cannot be a null!";
		} else if (job.getAvailability() == null || job.getAvailability().isEmpty()) {
			return "Availability cannot be a null!";
		} else if (job.getReplyRate() == 0) {
			return "replyRate cannot be a null!"; 
		} else if (job.getPayRate() == 0) {
			return "Payrate cannot be a null!";
		} else if (job.getExperience() == 0) {
			return "Experience cannot be a null!";
		} else if (job.getSkills() == null || job.getSkills().isEmpty()) {
			return "Skills cannot be a null!";
		} else if (job.getLanguage() == null || job.getLanguage().isEmpty()) {
			return "Language cannot be a null!";
		} else if (job.getJobType() == null || job.getJobType().isEmpty()) {
			return "JobType cannot be a null!";
		} else if (job.getUserInfo().getUserName() == null || job.getUserInfo().getUserName().isEmpty()) {
			return "UserName cannot be a null!";
		} else
			return null;
	}

	public static String validation(User user) {
		if (user.getUserName() == null || user.getUserName().isEmpty()) {
			return "UserName cannot be a null!";
		}
		return null;
	}

}
