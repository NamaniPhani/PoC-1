package com.ojas.ecom.response;

public class UserResponse {
	private String message;
	private String statusCode;
	private Object userList;

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

	public Object getUserList() {
		return userList;
	}

	public void setUserList(Object userList) {
		this.userList = userList;
	}

	

}
