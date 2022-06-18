package com.example.demo.data.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ReviewPK implements Serializable {
	/**
	 * 
	 */
    @Column(name = "book_id", nullable = false)
    private int bookId;
    @Column(name = "customer_id", nullable = false)
    private int customerId;
    
	public ReviewPK() {
		super();
	}
	public ReviewPK(int customerId, int bookId) {
		super();
		this.customerId = customerId;
		this.bookId = bookId;
	}
    
}
