package com.example.demo.data.entities;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "status", uniqueConstraints = {
	    @UniqueConstraint(columnNames = {"status_name"})})
@NamedQueries({
    @NamedQuery(name = "StatusEntity.findOrders", query = "SELECT s.ordersCollection FROM StatusEntity s where s.statusName = :statusName")})
public class StatusEntity {
	@Id
    @Column(name = "status_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer statusId;
    @Column(name = "status_name", nullable = false, length = 100)
    private String statusName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statusId")
    private Collection<OrderEntity> ordersCollection;
    
	public Integer getStatusId() {
		return statusId;
	}
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public Collection<OrderEntity> getOrdersCollection() {
		return ordersCollection;
	}
	public void setOrdersCollection(Collection<OrderEntity> ordersCollection) {
		this.ordersCollection = ordersCollection;
	}
    
}
