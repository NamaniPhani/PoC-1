package com.emp.response;

public class UserResponse {
private String message;
private Integer statusCode;
private Object userList;
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
public Object getUserList() {
	return userList;
}
public void setUserList(Object userList) {
	this.userList = userList;
}
@Override
public String toString() {
	return "UserResponse [message=" + message + ", statusCode=" + statusCode + ", userList=" + userList + "]";
}
}
