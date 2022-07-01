package com.example.demo.data.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CustomerForeignDto {
	@NotEmpty(message = "CustomerId must not be empty")
	@Pattern(regexp = "\\d*", message = "CustomerId must be a number")
	private String customerId;
	@Size(max = 255, message = "The length of the name must be less than 255 characters")
	public String name;
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
