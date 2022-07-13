package com.example.demo.data.dto;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class UpdateOrderDto {
	@Pattern(regexp = "\\d*", message = "StatusId must be a number")
	@NotEmpty(message = "StatusId must not be empty")
	private StatusDto statusId;
	public String updateDate;
	private EmployeeForeignDto employeeId;
	public StatusDto getStatusId() {
		return statusId;
	}
	public void setStatusId(StatusDto statusId) {
		this.statusId = statusId;
	}
	
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public EmployeeForeignDto getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(EmployeeForeignDto employeeId) {
		this.employeeId = employeeId;
	}
	
}
