package com.example.demo.response;

public class SuccessResponse {

	private String messagae;
	private Integer statusCode;
	private Object object;

	public SuccessResponse() {
		super();
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public SuccessResponse(Object object, Integer statusCode) {
		super();
		this.statusCode = statusCode;
		this.object = object;
	}

	public SuccessResponse(String messagae, Integer statusCode) {
		super();
		this.messagae = messagae;
		this.statusCode = statusCode;
	}

	public String getMessagae() {
		return messagae;
	}

	public void setMessagae(String messagae) {
		this.messagae = messagae;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	@Override
	public String toString() {
		return "SuccessResponse [messagae=" + messagae + ", statusCode=" + statusCode + "]";
	}

}
