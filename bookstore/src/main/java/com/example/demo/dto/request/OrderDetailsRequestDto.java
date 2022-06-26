package com.example.demo.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;


public class OrderDetailsRequestDto {
	@NotEmpty(message = "BookId must not be empty")
	@Pattern(regexp = "\\d*", message = "BookId must be a number")
	private String bookId;
	@NotEmpty(message = "Quantity must not be empty")
	@Pattern(regexp = "\\d*", message = "Quantity must be a number")
	private String quantity;
	@NotEmpty(message = "Unit Price must not be empty")
	@Pattern(regexp = "\\d*", message = "CustomerId must be a number")
	private String unitPrice;
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	
	
}
