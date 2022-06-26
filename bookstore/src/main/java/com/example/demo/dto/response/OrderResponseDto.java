package com.example.demo.dto.response;

import java.util.Date;
import java.util.List;

import com.example.demo.dto.request.EmployeeOrdRequestDto;

public class OrderResponseDto {
	private Integer orderId;
	private boolean confirmed;
	private Date createdDate;
	private long totalCash;
	private CustomerResponseDto customerId;
	private EmployeeOrdRequestDto employeeId;
	private List<OrderDetailsResponseDto> orderDetailsCollection;
	
	public CustomerResponseDto getCustomerId() {
		return customerId;
	}
	public void setCustomerId(CustomerResponseDto customerId) {
		this.customerId = customerId;
	}
	public EmployeeOrdRequestDto getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(EmployeeOrdRequestDto employeeId) {
		this.employeeId = employeeId;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public boolean isConfirmed() {
		return confirmed;
	}
	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public long getTotalCash() {
		return totalCash;
	}
	public void setTotalCash(long totalCash) {
		this.totalCash = totalCash;
	}
	public List<OrderDetailsResponseDto> getOrderDetailsCollection() {
		return orderDetailsCollection;
	}
	public void setOrderDetailsCollection(List<OrderDetailsResponseDto> orderDetailsCollection) {
		this.orderDetailsCollection = orderDetailsCollection;
	}
	
}
