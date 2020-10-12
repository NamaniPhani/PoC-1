package com.example.demo.response;

public class ErrorResponse extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	private Integer statusCode;

	public ErrorResponse() {
		super();
	}

	public ErrorResponse(String message) {
		super();
		this.message = message;
	}

	public ErrorResponse(String message, Integer statusCode) {
		super();
		this.message = message;
		this.statusCode = statusCode;
	}

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

	@Override
	public String toString() {
		return "ErrorResponse [message=" + message + ", statusCode=" + statusCode + "]";
	}
	
	
}
