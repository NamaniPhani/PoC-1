package com.emp.response;

public class PagenationResponse {
private Integer pageNo;
private Integer pageSize;
private Long totalRecords;
private Object jobList;
private String message;
private Integer statusCode;
public Object getJobList() {
	return jobList;
}
public void setJobList(Object jobList) {
	this.jobList = jobList;
}
public Integer getPageNo() {
	return pageNo;
}
public void setPageNo(Integer pageNo) {
	this.pageNo = pageNo;
}
public Integer getPageSize() {
	return pageSize;
}
public void setPageSize(Integer pageSize) {
	this.pageSize = pageSize;
}
public Long getTotalRecords() {
	return totalRecords;
}
public void setTotalRecords(Long totalRecords) {
	this.totalRecords = totalRecords;
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
	return "PagenationResponse [pageNo=" + pageNo + ", pageSize=" + pageSize + ", totalRecords=" + totalRecords
			+ ", jobList=" + jobList + ", message=" + message + ", statusCode=" + statusCode + "]";
}

}
