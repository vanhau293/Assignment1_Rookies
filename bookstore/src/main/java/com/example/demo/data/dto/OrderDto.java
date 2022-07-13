package com.example.demo.data.dto;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class OrderDto {
	@Pattern(regexp = "\\d*", message = "OrderId must be a number")
	private String orderId;
	public StatusDto statusId;
	public String updateDate;
	@Min(value = 0, message = "Total cash >= 0")
	@Pattern(regexp = "\\d*", message = "Total cash must be a number")
	public String totalCash;
	@NotEmpty(message = "CustomerId must not be empty")
	private CustomerForeignDto customerId;
	private EmployeeForeignDto employeeId;
	private List<OrderDetailsDto> orderDetails;
	@NotEmpty(message = "list Cart must not be empty")
	private List<CartDto> listCart;
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public CustomerForeignDto getCustomerId() {
		return customerId;
	}
	public void setCustomerId(CustomerForeignDto customerId) {
		this.customerId = customerId;
	}
	public EmployeeForeignDto getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(EmployeeForeignDto employeeId) {
		this.employeeId = employeeId;
	}
	public void setOrderDetails(List<OrderDetailsDto> orderDetails) {
		this.orderDetails = orderDetails;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
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
	public void setStatusId(StatusDto statusId) {
		this.statusId = statusId;
	}
	public List<CartDto> getListCart() {
		return listCart;
	}
	public void setListCart(List<CartDto> listCart) {
		this.listCart = listCart;
	}
	
	
}
