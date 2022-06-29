package com.example.demo.data.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;


public class OrderDetailsDto {
	@NotEmpty(message = "Book must not be empty")
	private BookDto bookEntity;
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
	public BookDto getBookEntity() {
		return bookEntity;
	}
	public void setBookEntity(BookDto bookEntity) {
		this.bookEntity = bookEntity;
	}
}
