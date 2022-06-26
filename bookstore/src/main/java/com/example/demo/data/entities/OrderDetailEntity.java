package com.example.demo.data.entities;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "order_details")
@Getter
@Setter
@NamedQueries({
    @NamedQuery(name = "OrderDetailEntity.findAll", query = "SELECT o FROM OrderDetailEntity o")
    , @NamedQuery(name = "OrderDetailEntity.findByOrderId", query = "SELECT o FROM OrderDetailEntity o WHERE o.orderDetailPK.orderId = :orderId")})
public class OrderDetailEntity {
	@EmbeddedId
    protected OrderDetailPK orderDetailPK;
    @Column(name = "quantity", nullable = false)
    private int quantity;
    @Column(name = "unit_price", nullable = false)
    private long unitPrice;
    @JoinColumn(name = "book_id", referencedColumnName = "book_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private BookEntity bookEntity;
    @JoinColumn(name = "order_id", referencedColumnName = "order_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private OrderEntity orderEntity;
    
    public OrderDetailEntity() {
    	super();
    }

    public OrderDetailEntity(OrderDetailPK orderDetailPK) {
    	super();
        this.orderDetailPK = orderDetailPK;
    }

    public OrderDetailEntity(OrderDetailPK orderDetailPK, int quantity, long unitPrice) {
    	super();
        this.orderDetailPK = orderDetailPK;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }
    
    public OrderDetailEntity(int quantity, long unitPrice) {
		super();
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}

	public OrderDetailEntity(int orderId, int bookId) {
    	super();
        this.orderDetailPK = new OrderDetailPK(orderId, bookId);
    }

	public OrderDetailPK getOrderDetailPK() {
		return orderDetailPK;
	}

	public void setOrderDetailPK(OrderDetailPK orderDetailPK) {
		this.orderDetailPK = orderDetailPK;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public long getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(long unitPrice) {
		this.unitPrice = unitPrice;
	}

	public BookEntity getBookEntity() {
		return bookEntity;
	}

	public void setBookEntity(BookEntity bookEntity) {
		this.bookEntity = bookEntity;
	}

	public OrderEntity getOrderEntity() {
		return orderEntity;
	}

	public void setOrderEntity(OrderEntity orderEntity) {
		this.orderEntity = orderEntity;
	}
	
}
