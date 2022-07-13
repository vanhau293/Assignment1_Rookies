package com.example.demo.data.dto;


public class OrderDetailsDto {
	private BookForeignDto bookEntity;
	private String quantity;
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
	public BookForeignDto getBookEntity() {
		return bookEntity;
	}
	public void setBookEntity(BookForeignDto bookEntity) {
		this.bookEntity = bookEntity;
	}
}
