package com.example.demo.data.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class EmployeeForeignDto {
	@NotEmpty(message = "CustomerId must not be empty")
	@Pattern(regexp = "\\d*", message = "CustomerId must be a number")
	private String employeeId;
	@Size(max = 255, message = "The length of the name must be less than 255 characters")
	public String name;
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
