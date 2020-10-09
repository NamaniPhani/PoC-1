package com.ojas.task.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlRootElement;

@Entity

@XmlRootElement
public class Job {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Pattern(regexp = "^[aA-zZ_ ]{1,30}$", message = "Provide Valid Job Title")
	private String jobTitle;

	@NotBlank(message = "Job Description Should Not Be Null Or Empty")
	private String jobDescription;

	@NotBlank(message = "Country Should Not Be Null Or Empty")
	private String country;

	@NotBlank(message = "State Should Not Be Null Or Empty")
	private String state;

	@NotBlank(message = "Availability Should Not Be Null Or Empty")
	private String availability;

	@NotNull(message = "Reply Rate Should Not Be Null Or Empty")
	private Integer replyRate;

	@NotNull(message = "Pay Rate Should Not Be Null Or Empty")
	private Integer payRate;

	@NotNull(message = "Experience Should Not Be Null Or Empty")
	private Integer experience;

	@NotBlank(message = "Skills Should Not Be Null Or Empty")
	private String skills;

	@NotBlank(message = "Language Should Not Be Null Or Empty")
	private String language;

	@NotBlank(message = "Job Type Should Not Be Null Or Empty")
	private String jobType;

	@OneToOne
	private User userInfo;

	public Job() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public Integer getReplyRate() {
		return replyRate;
	}

	public void setReplyRate(Integer replyRate) {
		this.replyRate = replyRate;
	}

	public Integer getPayRate() {
		return payRate;
	}

	public void setPayRate(Integer payRate) {
		this.payRate = payRate;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public User getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(User userInfo) {
		this.userInfo = userInfo;
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", jobTitle=" + jobTitle + ", jobDescription=" + jobDescription + ", country="
				+ country + ", state=" + state + ", availability=" + availability + ", replyRate=" + replyRate
				+ ", payRate=" + payRate + ", experience=" + experience + ", skills=" + skills + ", language="
				+ language + ", jobType=" + jobType + ", userInfo=" + userInfo + "]";
	}

}
