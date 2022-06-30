package com.example.demo.data.entities;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "cart")
@Getter
@Setter
@NamedQueries({
    @NamedQuery(name = "CartEntity.findAll", query = "SELECT c FROM CartEntity c")
    , @NamedQuery(name = "CartEntity.findByCustomerId", query = "SELECT c FROM CartEntity c WHERE c.cartPK.customerId = :customerId")
    , @NamedQuery(name = "CartEntity.findByCartPK", query = "SELECT c FROM CartEntity c WHERE c.cartPK = :cartPK")})
public class CartEntity {
	@EmbeddedId
    protected CartPK cartPK;
    @Column(name = "quantity", nullable = false)
    private int quantity;
    @JoinColumn(name = "book_id", referencedColumnName = "book_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private BookEntity bookEntity;
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CustomerEntity customerEntity;
	public CartEntity() {
		super();
	}
	public CartEntity(CartPK cartPK, int quantity, BookEntity bookEntity, CustomerEntity customer) {
		super();
		this.cartPK = cartPK;
		this.quantity = quantity;
		this.bookEntity = bookEntity;
		this.customerEntity = customer;
	}
	public CartEntity(CartPK cartPK) {
		super();
		this.cartPK = cartPK;
	}
	public CartPK getCartPK() {
		return cartPK;
	}
	public void setCartPK(CartPK cartPK) {
		this.cartPK = cartPK;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public BookEntity getBookEntity() {
		return bookEntity;
	}
	public void setBookEntity(BookEntity bookEntity) {
		this.bookEntity = bookEntity;
	}
	public CustomerEntity getCustomerEntity() {
		return customerEntity;
	}
	public void setCustomerEntity(CustomerEntity customerEntity) {
		this.customerEntity = customerEntity;
	}
    
    
}
