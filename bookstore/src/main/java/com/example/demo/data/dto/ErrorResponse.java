package com.example.demo.data.dto;

import java.util.Map;
public class ErrorResponse {
	String code;
	String message;
	Map<String, String> errors;
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
	public ErrorResponse(String code, String message, Map<String, String> errors) {
		super();
		this.code = code;
		this.message = message;
		this.errors = errors; 
	}
	public Map<String, String> getErrors() {
		return errors;
	}
	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}
	
	
}
