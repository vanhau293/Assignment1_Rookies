package com.example.demo.data.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RatingPK {
	@Basic(optional = false)
    @Column(name = "customer_id")
    private int customerId;
    @Basic(optional = false)
    @Column(name = "book_id")
    private int bookId;
    
	public RatingPK() {
		super();
	}
	public RatingPK(int customerId, int bookId) {
		super();
		this.customerId = customerId;
		this.bookId = bookId;
	}
    
}
