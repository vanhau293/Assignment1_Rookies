package com.example.demo.data.entities;

import java.util.Collection;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "customers", uniqueConstraints = {
	    @UniqueConstraint(columnNames = {"account_id"})})
@Getter
@Setter
@NamedQueries({
    @NamedQuery(name = "CustomerEntity.findAll", query = "SELECT c FROM CustomerEntity c")
    , @NamedQuery(name = "CustomerEntity.findByCustomerId", query = "SELECT c FROM CustomerEntity c WHERE c.customerId = :customerId")
    , @NamedQuery(name = "CustomerEntity.findByPhoneNumber", query = "SELECT c FROM CustomerEntity c WHERE c.phoneNumber = :phoneNumber")
    , @NamedQuery(name = "CustomerEntity.findByEmail", query = "SELECT c FROM CustomerEntity c WHERE c.email = :email")})
public class CustomerEntity {
	@Id
    @Column(name = "customer_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
    @Column(name = "address", length = 255)
    private String address;
    @Column(name = "email", length = 100)
    private String email;
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Column(name = "phone_number", nullable = false, length = 10)
    private String phoneNumber;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerEntity")
    private Collection<CartEntity> cartCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerEntity")
    private Collection<ReviewEntity> reviewsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerId")
    private Collection<OrderEntity> ordersCollection;
    @JoinColumn(name = "account_id", referencedColumnName = "account_id")
    @OneToOne
    private AccountEntity accountId;

    
    public CustomerEntity() {
		super();
	}
	public CustomerEntity(String name, String address, String phoneNumber, String email) {
		super();
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
    
    
}
