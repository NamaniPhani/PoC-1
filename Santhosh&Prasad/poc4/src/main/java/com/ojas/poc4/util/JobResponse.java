package com.ojas.poc4.util;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.ojas.poc4.model.JobModel;


/**
 * @author Prasad Rachamalla
 *
 */
@XmlRootElement
public class JobResponse {
	private int statusCode;
	private String status;
	private String message;
	private List<JobModel> data;
	
	
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
	public List<JobModel> getData() {
		return data;
	}
	public void setData(List<JobModel> data) {
		this.data = data;
	}
	

}
