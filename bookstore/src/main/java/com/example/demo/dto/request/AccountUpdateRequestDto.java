package com.example.demo.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class AccountUpdateRequestDto {
	
	@NotEmpty(message = "Password must not be empty")
	@Size(min = 6, max = 40, message = "The length of the password must be between 6 and 40 characters")
	private String password;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
