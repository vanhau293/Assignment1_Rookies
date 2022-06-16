package com.example.demo.data.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "order")
@Getter
@Setter
@NamedQueries({
    @NamedQuery(name = "Order.findAll", query = "SELECT o FROM Order1 o")
    , @NamedQuery(name = "Order.findByOrderId", query = "SELECT o FROM Order1 o WHERE o.orderId = :orderId")})
public class Order {
	@Id
    @Basic(optional = false)
    @Column(name = "order_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    @Basic(optional = false)
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Basic(optional = false)
    @Column(name = "total_cash")
    private long totalCash;
    @Basic(optional = false)
    @Column(name = "confirmed")
    private boolean confirmed;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private Collection<OrderDetail> orderDetailCollection;
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    @ManyToOne(optional = false)
    private Customer customerId;
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    @ManyToOne
    private Employee employeeId;
    
    public Order() {
    	super();
    }

    public Order(Date createdDate, long totalCash, boolean confirmed, Employee employee) {
    	super();
        this.createdDate = createdDate;
        this.totalCash = totalCash;
        this.confirmed = confirmed;
        this.employeeId = employee;
    }
}
