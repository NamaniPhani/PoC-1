package com.example.test.response;

public class ErrorResponse {
	private String message;
	private Integer statusCode;

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

	public ErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ErrorResponse(String message, Integer statusCode, Object object) {
		super();
		this.message = message;
		this.statusCode = statusCode;
	}

	@Override
	public String toString() {
		return "SuccessResponse [message=" + message + ", statusCode=" + statusCode + "]";
	}

}
