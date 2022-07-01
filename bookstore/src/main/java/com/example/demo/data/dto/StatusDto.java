package com.example.demo.data.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class StatusDto {
	@Pattern(regexp = "\\d*", message = "StatusId must be a number")
	@NotEmpty(message = "StatusId must not be empty")
	private Integer statusId;
	public String statusName;
	public Integer getStatusId() {
		return statusId;
	}
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
}
