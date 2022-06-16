package com.example.demo.data.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class OrderDetailPK {
	@Basic(optional = false)
    @Column(name = "order_id")
    private int orderId;
    @Basic(optional = false)
    @Column(name = "book_id")
    private int bookId;
    
	public OrderDetailPK() {
		super();
	}

	public OrderDetailPK(int orderId, int bookId) {
		super();
		this.orderId = orderId;
		this.bookId = bookId;
	}
}
