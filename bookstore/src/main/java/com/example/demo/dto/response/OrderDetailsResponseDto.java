package com.example.demo.dto.response;

public class OrderDetailsResponseDto {
	private String quantity;
	private String unitPrice;
	private BookOrderDetailsResponseDto bookEntity;
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
	public BookOrderDetailsResponseDto getBookEntity() {
		return bookEntity;
	}
	public void setBookEntity(BookOrderDetailsResponseDto bookEntity) {
		this.bookEntity = bookEntity;
	}
	
}
