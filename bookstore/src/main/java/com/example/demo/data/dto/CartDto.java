package com.example.demo.data.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.example.demo.data.entities.CartPK;

public class CartDto {
	private CartPK cartPK;
	@NotEmpty(message = "Quantity must not be empty")
	@Pattern(regexp = "\\d*", message = "Quantity must be a number")
	@Min(value = 0, message = "Quantity >= 1")
	private String quantity;
	public BookForeignDto bookEntity;
	public CartPK getCartPK() {
		return cartPK;
	}
	public void setCartPK(CartPK cartPK) {
		this.cartPK = cartPK;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public void setBookEntity(BookForeignDto bookEntity) {
		this.bookEntity = bookEntity;
	}
	
}
