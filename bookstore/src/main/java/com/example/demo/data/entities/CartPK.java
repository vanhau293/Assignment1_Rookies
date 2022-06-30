package com.example.demo.data.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CartPK implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    @Column(name = "book_id", nullable = false)
    private int bookId;
    @Column(name = "customer_id", nullable = false)
    private int customerId;
    
	public CartPK() {
		super();
	}

	public CartPK(int customerId, int bookId) {
		super();
		this.customerId = customerId;
		this.bookId = bookId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
    
    
}
