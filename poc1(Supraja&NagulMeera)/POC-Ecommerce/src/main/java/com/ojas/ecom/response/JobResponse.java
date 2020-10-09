package com.ojas.ecom.response;

public class JobResponse {
	private String message;
	private String statusCode;
	private Object jobList;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public Object getJobList() {
		return jobList;
	}

	public void setJobList(Object jobList) {
		this.jobList = jobList;
	}

	
}
