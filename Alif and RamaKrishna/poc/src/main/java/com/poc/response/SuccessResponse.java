package com.poc.response;

import java.util.List;

import com.poc.model.Job;
import com.poc.model.User;

public class SuccessResponse {

	private String statusCode;
	private String statusMessage;
	private List<User> userList;
	private List<Job> joblist;

	

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	public List<Job> getJoblist() {
		return joblist;
	}

	public void setJoblist(List<Job> joblist) {
		this.joblist = joblist;
	}

}
