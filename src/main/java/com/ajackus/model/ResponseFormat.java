package com.ajackus.model;

import java.io.Serializable;

public class ResponseFormat implements Serializable{

	private String status;
	
    private String message;
    
    private Integer statusCode;
    
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

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	@Override
	public String toString() {
		return "ResponseFormat [status=" + status + ", message=" + message + ", statusCode=" + statusCode + "]";
	}
}