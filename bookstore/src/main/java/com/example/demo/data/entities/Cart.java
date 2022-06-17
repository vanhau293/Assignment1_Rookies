package com.example.demo.data.entities;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "cart")
@Getter
@Setter
@NamedQueries({
    @NamedQuery(name = "Cart.findAll", query = "SELECT c FROM Cart c")
    , @NamedQuery(name = "Cart.findByCustomerId", query = "SELECT c FROM Cart c WHERE c.cartPK.customerId = :customerId")})
public class Cart {
	@EmbeddedId
    protected CartPK cartPK;
    @Column(name = "quantity", nullable = false)
    private int quantity;
    @JoinColumn(name = "book_id", referencedColumnName = "book_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Books books;
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Customers customers;
	public Cart() {
		super();
	}
	public Cart(CartPK cartPK, int quantity, Books books, Customers customer) {
		super();
		this.cartPK = cartPK;
		this.quantity = quantity;
		this.books = books;
		this.customers = customer;
	}
	public Cart(CartPK cartPK) {
		super();
		this.cartPK = cartPK;
	}
    
    
}