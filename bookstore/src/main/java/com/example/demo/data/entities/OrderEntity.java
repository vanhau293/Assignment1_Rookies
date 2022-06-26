package com.example.demo.data.entities;

import java.time.LocalDateTime;
import java.util.Collection;


import javax.persistence.*;


import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "orders")
@Getter
@Setter
@NamedQueries({
    @NamedQuery(name = "OrderEntity.findAll", query = "SELECT o FROM OrderEntity o where o.confirmed = true")
    , @NamedQuery(name = "OrderEntity.findOrdersOfDate", query = "SELECT o FROM OrderEntity o where day(o.createdDate) = :date and o.confirmed = true")
    , @NamedQuery(name = "OrderEntity.findOrdersPending", query = "SELECT o FROM OrderEntity o WHERE o.confirmed = false")
    , @NamedQuery(name = "OrderEntity.findByOrderId", query = "SELECT o FROM OrderEntity o WHERE o.orderId = :orderId")})
public class OrderEntity {
	@Id
    @Column(name = "order_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    @Column(name = "confirmed", nullable = false)
    private boolean confirmed;
    @Column(name = "created_date", nullable = false)
    //@Temporal(TemporalType.TIMESTAMP)
    //@DateTimeFormat(pattern = "HH:mm:ss.SSS dd-MM-yyyy")
    private LocalDateTime createdDate;
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

    public OrderEntity(Integer orderId) {
		super();
		this.orderId = orderId;
	}

	public OrderEntity(LocalDateTime createdDate, long totalCash, boolean confirmed, EmployeeEntity employeeEntity) {
    	super();
        this.createdDate = createdDate;
        this.totalCash = totalCash;
        this.confirmed = confirmed;
        this.employeeId = employeeEntity;
    }

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public boolean isConfirmed() {
		return confirmed;
	}

	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public long getTotalCash() {
		return totalCash;
	}

	public void setTotalCash(long totalCash) {
		this.totalCash = totalCash;
	}

	public Collection<OrderDetailEntity> getOrderDetailsCollection() {
		return orderDetailsCollection;
	}

	public void setOrderDetailsCollection(Collection<OrderDetailEntity> orderDetailsCollection) {
		this.orderDetailsCollection = orderDetailsCollection;
	}

	public CustomerEntity getCustomerId() {
		return customerId;
	}

	public void setCustomerId(CustomerEntity customerId) {
		this.customerId = customerId;
	}

	public EmployeeEntity getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(EmployeeEntity employeeId) {
		this.employeeId = employeeId;
	}
    
}
