package com.example.demo.dto.response;

import java.util.Map;

public class ErrorResponse {
	String code;
	String message;
	Map<String, String> validationErrors;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ErrorResponse(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	public ErrorResponse(String code, String message, Map<String, String> validationErrors) {
		super();
		this.code = code;
		this.message = message;
		this.validationErrors = validationErrors; 
	}
	
	
}
