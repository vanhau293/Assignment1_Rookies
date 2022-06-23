package com.example.demo.exceptions;

public class UnauthorizedException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public UnauthorizedException() {
		super();
	}
	public UnauthorizedException(String message) {
		super(message);
		
	}
	public UnauthorizedException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
