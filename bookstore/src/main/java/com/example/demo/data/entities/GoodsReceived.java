package com.example.demo.data.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "goods_received")
@Getter
@Setter
@NamedQueries({
    @NamedQuery(name = "GoodsReceived.findAll", query = "SELECT g FROM GoodsReceived g")
    , @NamedQuery(name = "GoodsReceived.findByReceivedId", query = "SELECT g FROM GoodsReceived g WHERE g.receivedId = :receivedId")})
public class GoodsReceived {
	@Id
    @Basic(optional = false)
    @Column(name = "received_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer receivedId;
    @Basic(optional = false)
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Basic(optional = false)
    @Column(name = "total_cash")
    private long totalCash;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "goodsReceived")
    private Collection<ReceivedDetail> receivedDetailCollection;
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    @ManyToOne(optional = false)
    private Employee employeeId;
    
	public GoodsReceived() {
		super();
	}

	public GoodsReceived(Date createdDate, long totalCash, Employee employeeId) {
		super();
		this.createdDate = createdDate;
		this.totalCash = totalCash;
		this.employeeId = employeeId;
	}
    
}
