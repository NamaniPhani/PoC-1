package com.emp.response;

public class SkillsResponse {
	private String message;
	private String statusCode;
	private Object skillsList;
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
	public Object getSkillsList() {
		return skillsList;
	}
	public void setSkillsList(Object skillsList) {
		this.skillsList = skillsList;
	}
	@Override
	public String toString() {
		return "SkillsResponse [message=" + message + ", statusCode=" + statusCode + ", skillsList=" + skillsList + "]";
	}
}
	