package com.example.demo.data.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class OrderDetailPK implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    @Column(name = "book_id", nullable = false)
    private int bookId;
    @Column(name = "order_id", nullable = false)
    private int orderId;
    
	public OrderDetailPK() {
		super();
	}

	public OrderDetailPK(int orderId, int bookId) {
		super();
		this.orderId = orderId;
		this.bookId = bookId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
