package com.ojas.poc4.util;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.ojas.poc4.model.User;

/**
 * @author Prasad Rachamalla
 *
 */
@XmlRootElement
public class UserResponse {
	private int statusCode;
	private String status;
	private String message;
	private List<User> data;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<User> getData() {
		return data;
	}
	public void setData(List<User> data) {
		this.data = data;
	}
	
}
