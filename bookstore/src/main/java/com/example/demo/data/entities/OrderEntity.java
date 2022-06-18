package com.example.demo.data.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "orders")
@Getter
@Setter
@NamedQueries({
    @NamedQuery(name = "OrderEntity.findAll", query = "SELECT o FROM OrderEntity o")
    , @NamedQuery(name = "OrderEntity.findByOrderId", query = "SELECT o FROM OrderEntity o WHERE o.orderId = :orderId")})
public class OrderEntity {
	@Id
    @Column(name = "order_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    @Column(name = "confirmed", nullable = false)
    private boolean confirmed;
    @Column(name = "created_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "HH:mm:ss.SSS dd-MM-yyyy")
    private Date createdDate;
    @Basic(optional = false)
    @Column(name = "total_cash", nullable = false)
    private long totalCash;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderEntity")
    private Collection<OrderDetailEntity> orderDetailsCollection;
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false)
    @ManyToOne(optional = false)
    private CustomerEntity customerId;
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    @ManyToOne
    private EmployeeEntity employeeId;
    
    public OrderEntity() {
    	super();
    }

    public OrderEntity(Date createdDate, long totalCash, boolean confirmed, EmployeeEntity employeeEntity) {
    	super();
        this.createdDate = createdDate;
        this.totalCash = totalCash;
        this.confirmed = confirmed;
        this.employeeId = employeeEntity;
    }
}
