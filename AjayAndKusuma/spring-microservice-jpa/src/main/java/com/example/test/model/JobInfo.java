package com.example.test.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "jobinfo")
@XmlRootElement
public class JobInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank(message = "jobTitle should not be null")
	private String jobTitle;
	@NotBlank(message = "jobDescription should not be null")
	private String jobDescription;
	@NotBlank(message = "country should not be null")
	private String country;
	@NotBlank(message = "state should not be null")
	private String state;
	@NotBlank(message = "availability should not be null")
	private String availability;
	@NotNull(message = "replyRate should not be null")
	private Integer replyRate;
	@NotNull(message = "payRate should not be null")
	private Integer payRate;
	@NotNull(message = "experience should not be null")
	private Integer experience;
	@NotBlank(message = "skills should not be null")
	private String skills;
	@NotBlank(message = "language should not be null")
	private String language;
	@NotBlank(message = "jobType should not be null")
	private String jobType;

	@OneToOne
	private User user;

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public JobInfo(Integer id, String jobTitle, String jobDescription, String country, String state,
			String availability, Integer replyRate, Integer payRate, Integer experience, String skills, String language,
			String jobType, User user) {
		super();
		this.id = id;
		this.jobTitle = jobTitle;
		this.jobDescription = jobDescription;
		this.country = country;
		this.state = state;
		this.availability = availability;
		this.replyRate = replyRate;
		this.payRate = payRate;
		this.experience = experience;
		this.skills = skills;
		this.language = language;
		this.jobType = jobType;
		this.user = user;
	}

	public JobInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "JobInfo [id=" + id + ", jobTitle=" + jobTitle + ", jobDescription=" + jobDescription + ", country="
				+ country + ", state=" + state + ", availability=" + availability + ", replyRate=" + replyRate
				+ ", payRate=" + payRate + ", experience=" + experience + ", skills=" + skills + ", language="
				+ language + ", jobType=" + jobType + ", user=" + user + "]";
	}

}