package com.example.demo.data.entities;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "order_details")
@Getter
@Setter
@NamedQueries({
    @NamedQuery(name = "OrderDetails.findAll", query = "SELECT o FROM OrderDetails o")
    , @NamedQuery(name = "OrderDetails.findByOrderId", query = "SELECT o FROM OrderDetails o WHERE o.orderDetailsPK.orderId = :orderId")})
public class OrderDetails {
	@EmbeddedId
    protected OrderDetailsPK orderDetailsPK;
    @Column(name = "quantity", nullable = false)
    private int quantity;
    @Column(name = "unit_price", nullable = false)
    private long unitPrice;
    @JoinColumn(name = "book_id", referencedColumnName = "book_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Books books;
    @JoinColumn(name = "order_id", referencedColumnName = "order_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Orders orders;
    
    public OrderDetails() {
    	super();
    }

    public OrderDetails(OrderDetailsPK orderDetailsPK) {
    	super();
        this.orderDetailsPK = orderDetailsPK;
    }

    public OrderDetails(OrderDetailsPK orderDetailsPK, int quantity, long unitPrice) {
    	super();
        this.orderDetailsPK = orderDetailsPK;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public OrderDetails(int orderId, int bookId) {
    	super();
        this.orderDetailsPK = new OrderDetailsPK(orderId, bookId);
    }
}
