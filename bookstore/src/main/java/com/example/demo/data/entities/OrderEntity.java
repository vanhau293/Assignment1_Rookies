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
    @NamedQuery(name = "OrderEntity.findAll", query = "SELECT o FROM OrderEntity o")
    , @NamedQuery(name = "OrderEntity.findOrdersWithStatus", query = "SELECT o FROM OrderEntity o where o.statusId.statusId = :statusId")
    , @NamedQuery(name = "OrderEntity.findOrdersOnDate", query = "SELECT o FROM OrderEntity o where day(o.updateDate) = :date")
    , @NamedQuery(name = "OrderEntity.findOrders", query = "SELECT o FROM OrderEntity o where day(o.updateDate) = :date and o.statusId = :statusId")
    , @NamedQuery(name = "OrderEntity.findByOrderId", query = "SELECT o FROM OrderEntity o WHERE o.orderId = :orderId")})
public class OrderEntity {
	@Id
    @Column(name = "order_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    @Column(name = "update_date", nullable = false)
    //@Temporal(TemporalType.TIMESTAMP)
    //@DateTimeFormat(pattern = "HH:mm:ss.SSS dd-MM-yyyy")
    private LocalDateTime updateDate;
    @Basic(optional = false)
    @Column(name = "total_cash", nullable = false)
    private long totalCash;
    @JoinColumn(name = "status_id", referencedColumnName = "status_id")
    @ManyToOne(optional = false)
    private StatusEntity statusId;
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

    public StatusEntity getStatusId() {
		return statusId;
	}

	public void setStatusId(StatusEntity statusId) {
		this.statusId = statusId;
	}

	public OrderEntity(Integer orderId) {
		super();
		this.orderId = orderId;
	}

	public OrderEntity(LocalDateTime createdDate, long totalCash, EmployeeEntity employeeEntity) {
    	super();
        this.updateDate = createdDate;
        this.totalCash = totalCash;
        this.employeeId = employeeEntity;
    }

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public LocalDateTime getCreatedDate() {
		return updateDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.updateDate = createdDate;
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
