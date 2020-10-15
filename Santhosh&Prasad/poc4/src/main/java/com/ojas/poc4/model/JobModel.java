package com.ojas.poc4.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;




/**
 * @author Prasad Rachamalla
 *
 */
@Entity
@Table(name="job")
@XmlRootElement
public class JobModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	@NotNull(message="Job Title is Required")	
	@Column(name="job_tite")
	private String jobTitle;
	@NotBlank(message="Job Description is Required")
	@Size(min=3,max=250)
	@Column(name="job_description")
	private String jobDescription;
	@NotBlank(message="Country is Required")
	@Size(min=2,max=250)
	@Column(name="country")
	private String country;
	@NotBlank(message="State is Required")
	@Size(min=2,max=250)
	@Column(name="state")
	private String state;
	@NotBlank(message="Availability is Required")
	@Size(min=2,max=250)
	@Column(name="availability")
	private String availability;
	@NotNull(message="Reply Rate is Required")	
	@Column(name="reply_rate")
	private int replyRate;
	@NotNull(message="Pay Rate is Required")	
	@Column(name="pay_rate")
	private int payRate;
	@NotNull(message="Experience is Required")	
	@Column(name="experience")
	private float experience;
	@NotBlank(message="Skills is Required")
	@Size(min=2,max=250)
	@Column(name="skills")
	private String skills;
	@NotBlank(message="Language is Required")
	@Size(min=2,max=250)
	@Column(name="language")
	private String language;
	@NotBlank(message="Job Type is Required")
	@Size(min=2,max=250)
	@Column(name="job_type")
	private String jobType;	
	@OneToOne(targetEntity = User.class)
	private User userInfo;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public int getReplyRate() {
		return replyRate;
	}
	public void setReplyRate(int replyRate) {
		this.replyRate = replyRate;
	}
	public int getPayRate() {
		return payRate;
	}
	public void setPayRate(int payRate) {
		this.payRate = payRate;
	}
	public float getExperience() {
		return experience;
	}
	public void setExperience(float experience) {
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
	
	
	

}
