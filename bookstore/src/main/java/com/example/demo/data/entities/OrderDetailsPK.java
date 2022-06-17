package com.example.demo.data.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class OrderDetailsPK implements Serializable{
	/**
	 * 
	 */
    @Column(name = "book_id", nullable = false)
    private int bookId;
    @Column(name = "order_id", nullable = false)
    private int orderId;
    
	public OrderDetailsPK() {
		super();
	}

	public OrderDetailsPK(int orderId, int bookId) {
		super();
		this.orderId = orderId;
		this.bookId = bookId;
	}
}
