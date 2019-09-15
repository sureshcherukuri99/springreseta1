package com.hickory.springboot;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

public class Response {
	
	private String message;
	private HttpStatus status;
	private int statusCode;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public Response(String message, HttpStatus status, int statusCode) {
		
		this.message = message;
		this.status = status;
		this.statusCode = statusCode;
	}
	public Response() {};

	
	

}
