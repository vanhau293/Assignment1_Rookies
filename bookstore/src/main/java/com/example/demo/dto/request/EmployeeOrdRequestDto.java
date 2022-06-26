package com.example.demo.dto.request;

import javax.validation.constraints.Pattern;

public class EmployeeOrdRequestDto {
	@Pattern(regexp = "\\d*", message = "EmployeeId must be a number")
	private String employeeId;

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
}
