package com.emp.response;

public class JobResponse {
private String message;
private Integer statusCode;
private Object jobList;
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public Integer getStatusCode() {
	return statusCode;
}
public void setStatusCode(Integer statusCode) {
	this.statusCode = statusCode;
}
public Object getJobList() {
	return jobList;
}
public void setJobList(Object jobList) {
	this.jobList = jobList;
}
@Override
public String toString() {
	return "JobResponse [message=" + message + ", statusCode=" + statusCode + ", jobList=" + jobList + "]";
}
}
