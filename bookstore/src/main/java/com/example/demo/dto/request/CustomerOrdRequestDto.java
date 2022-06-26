package com.example.demo.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class CustomerOrdRequestDto {
	@NotEmpty(message = "CustomerId must not be empty")
	@Pattern(regexp = "\\d*", message = "CustomerId must be a number")
	private String customerId;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
}
