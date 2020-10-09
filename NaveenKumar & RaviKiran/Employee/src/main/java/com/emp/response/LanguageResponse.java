package com.emp.response;

public class LanguageResponse {
private String message;
private String statusCode;
private Object languageList;
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
public Object getLanguageList() {
	return languageList;
}
public void setLanguageList(Object languageList) {
	this.languageList = languageList;
}
@Override
public String toString() {
	return "LanguageResponse [message=" + message + ", statusCode=" + statusCode + ", languageList=" + languageList
			+ "]";
}
}
