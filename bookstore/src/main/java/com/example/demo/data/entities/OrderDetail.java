package com.example.demo.data.entities;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "order_detail")
@Getter
@Setter
@NamedQueries({
    @NamedQuery(name = "OrderDetail.findAll", query = "SELECT o FROM OrderDetail o")
    , @NamedQuery(name = "OrderDetail.findByOrderId", query = "SELECT o FROM OrderDetail o WHERE o.orderDetailPK.orderId = :orderId")})
public class OrderDetail {
	@EmbeddedId
    protected OrderDetailPK orderDetailPK;
    @Basic(optional = false)
    @Column(name = "quantity")
    private int quantity;
    @Basic(optional = false)
    @Column(name = "unit_price")
    private long unitPrice;
    @JoinColumn(name = "book_id", referencedColumnName = "book_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Book book;
    @JoinColumn(name = "order_id", referencedColumnName = "order_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Order order;
    
    public OrderDetail() {
    	super();
    }

    public OrderDetail(OrderDetailPK orderDetailPK) {
    	super();
        this.orderDetailPK = orderDetailPK;
    }

    public OrderDetail(OrderDetailPK orderDetailPK, int quantity, long unitPrice) {
    	super();
        this.orderDetailPK = orderDetailPK;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public OrderDetail(int orderId, int bookId) {
    	super();
        this.orderDetailPK = new OrderDetailPK(orderId, bookId);
    }
}
