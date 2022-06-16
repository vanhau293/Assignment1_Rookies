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
    @Basic(optional = false)
    @Column(name = "quantity")
    private int quantity;
    @JoinColumn(name = "book_id", referencedColumnName = "book_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Book book;
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Customer customer;
	public Cart() {
		super();
	}
	public Cart(CartPK cartPK, int quantity, Book book, Customer customer) {
		super();
		this.cartPK = cartPK;
		this.quantity = quantity;
		this.book = book;
		this.customer = customer;
	}
	public Cart(CartPK cartPK) {
		super();
		this.cartPK = cartPK;
	}
    
    
}
