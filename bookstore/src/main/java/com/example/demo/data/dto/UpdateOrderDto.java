package com.example.demo.data.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class UpdateOrderDto {
	@Pattern(regexp = "\\d*", message = "StatusId must be a number")
	@NotEmpty(message = "StatusId must not be empty")
	private StatusDto statusId;
	@NotEmpty(message = "UpdateDate must not be empty")
	//2022-06-28T12:25:32.020
	@Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}.\\d*", 
	message = "Created date must be a day like (yyyy-MM-ddTHH:mm:ss.SSS)")
	private String updateDate;
	private EmployeeForeignDto employeeId;
	public StatusDto getStatusId() {
		return statusId;
	}
	public void setStatusId(StatusDto statusId) {
		this.statusId = statusId;
	}
	public LocalDateTime getUpdateDate(){
		return LocalDateTime.parse(updateDate);
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
