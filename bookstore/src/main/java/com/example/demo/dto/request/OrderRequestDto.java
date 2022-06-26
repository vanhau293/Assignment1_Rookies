package com.example.demo.dto.request;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class OrderRequestDto {
	@NotEmpty(message = "CustomerId must not be empty")
	//@Pattern(regexp = "\\d{2}:\\d{2}:\\d{2}.\\d* \\d{2}[-|/]\\d{2}[-|/]\\d{4}", 
	//message = "Created date must be a day like (HH:mm:ss.SSS dd/MM/yyyy) or (HH:mm:ss.SSS dd-MM-yyyy)")
	private String createdDate;
	@NotEmpty(message = "Total cash must not be empty")
	@Min(value = 0, message = "Total cash >= 0")
	@Pattern(regexp = "\\d*", message = "Total cash must be a number")
	private String totalCash;
	private List<OrderDetailsRequestDto> orderDetails;
	private CustomerOrdRequestDto customerId;
	private EmployeeOrdRequestDto employeeId;
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getTotalCash() {
		return totalCash;
	}
	public void setTotalCash(String totalCash) {
		this.totalCash = totalCash;
	}
	public List<OrderDetailsRequestDto> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetailsCollection(List<OrderDetailsRequestDto> orderDetails) {
		this.orderDetails = orderDetails;
	}
	public CustomerOrdRequestDto getCustomerId() {
		return customerId;
	}
	public void setCustomerId(CustomerOrdRequestDto customerId) {
		this.customerId = customerId;
	}
	public EmployeeOrdRequestDto getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(EmployeeOrdRequestDto employeeId) {
		this.employeeId = employeeId;
	}
	
	
}
