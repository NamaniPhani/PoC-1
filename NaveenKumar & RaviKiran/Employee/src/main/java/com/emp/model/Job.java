package com.emp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Job implements Serializable {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "job_id")
	private Integer jobId;

	@Size(min = 3, max = 20)
	@NotBlank(message = "jobtitle is mandatory")
	@Column(name = "job_title")
	private String jobTitle;

	@Size(min = 3, max = 30)
	@NotBlank(message = "job_description is mandatory")
	@Column(name = "job_description")
	private String jobDescription;

	@Pattern(regexp = "^[a-zA-Z]{2,10}", message = "should not enter special characters and numbers and size should be minimum 2 for country")
	@NotBlank(message = "country is mandatory")
	@Column
	private String country;

	@Pattern(regexp = "^[a-zA-Z]{2,10}", message = "should not enter special characters and numbers and size should be minimum 2 for state")
	@NotBlank(message = "state is mandatory")
	@Column
	private String state;

	@NotBlank(message = "availability is mandatory")
	@Column
	private String availability;

	@NotNull(message = "replyrate is mandatory")
	@Column(name = "reply_rate")
	private Integer replyRate;

	@NotNull(message = "payrate is mandatory")
	@Column(name = "pay_rate")
	private Integer payRate;

	@NotNull(message = "experience is mandatory")
	@Column
	private Float experience;

	@NotBlank(message = "skills are mandatory")
	@ManyToOne
	private Skills skills;

	@NotBlank(message = "language is mandatory")
	@ManyToOne
	private Language language;

	@NotBlank(message = "jobType is mandatory")
	@Column(name = "job_type")
	private String jobType;

	@OneToOne
	private User user;

	public Skills getSkills() {
		return skills;
	}

	public void setSkills(Skills skills) {
		this.skills = skills;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public Integer getJobId() {
		return jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
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

	public Float getExperience() {
		return experience;
	}

	public void setExperience(Float experience) {
		this.experience = experience;
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

	@Override
	public String toString() {
		return "Job [jobId=" + jobId + ", jobTitle=" + jobTitle + ", jobDescription=" + jobDescription + ", country="
				+ country + ", state=" + state + ", availability=" + availability + ", replyRate=" + replyRate
				+ ", payRate=" + payRate + ", experience=" + experience + ", skills=" + skills + ", language="
				+ language + ", jobType=" + jobType + ", user=" + user + "]";
	}
}
