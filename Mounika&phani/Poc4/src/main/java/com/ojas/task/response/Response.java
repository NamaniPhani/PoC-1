package com.ojas.task.response;

public class Response {

	private Object object;
	private String message;
	private Integer status;

	public Response() {
		super();
	}

	public Response(Object object, String message, Integer status) {
		super();
		this.object = object;
		this.message = message;
		this.status = status;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Response [object=" + object + ", message=" + message + ", status=" + status + "]";
	}

}
