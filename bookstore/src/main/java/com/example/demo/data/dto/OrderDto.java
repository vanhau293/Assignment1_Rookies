package com.example.demo.data.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class OrderDto {
	private Integer orderId;
	private StatusDto statusId;
	@NotEmpty(message = "UpdateDate must not be empty")
	//2022-06-28T12:25:32.020
	@Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}.\\d*", 
	message = "Created date must be a day like (yyyy-MM-ddTHH:mm:ss.SSS)")
	private String updateDate;
	@NotEmpty(message = "Total cash must not be empty")
	@Min(value = 0, message = "Total cash >= 0")
	@Pattern(regexp = "\\d*", message = "Total cash must be a number")
	private String totalCash;
	private CustomerDto customerId;
	private EmployeeDto employeeId;
	private List<OrderDetailsDto> orderDetails;
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public CustomerDto getCustomerId() {
		return customerId;
	}
	public void setCustomerId(CustomerDto customerId) {
		this.customerId = customerId;
	}
	public EmployeeDto getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(EmployeeDto employeeId) {
		this.employeeId = employeeId;
	}
	public void setOrderDetails(List<OrderDetailsDto> orderDetails) {
		this.orderDetails = orderDetails;
	}
	public LocalDateTime getUpdateDate(){

		return LocalDateTime.parse(updateDate);
	
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public String getTotalCash() {
		return totalCash;
	}
	public void setTotalCash(String totalCash) {
		this.totalCash = totalCash;
	}
	public List<OrderDetailsDto> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetailsCollection(List<OrderDetailsDto> orderDetails) {
		this.orderDetails = orderDetails;
	}
	public StatusDto getStatusId() {
		return statusId;
	}
	public void setStatusId(StatusDto statusId) {
		this.statusId = statusId;
	}
	
	
}
