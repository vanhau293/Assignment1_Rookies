package com.example.demo.data.entities;

import java.util.Collection;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "employees", uniqueConstraints = {
	    @UniqueConstraint(columnNames = {"account_id"})})
@Getter
@Setter
@NamedQueries({
    @NamedQuery(name = "EmployeeEntity.findAll", query = "SELECT e FROM EmployeeEntity e")
    , @NamedQuery(name = "EmployeeEntity.findByEmployeeId", query = "SELECT e FROM EmployeeEntity e WHERE e.employeeId = :employeeId")
    , @NamedQuery(name = "EmployeeEntity.findByPhoneNumber", query = "SELECT e FROM EmployeeEntity e WHERE e.phoneNumber = :phoneNumber")
    , @NamedQuery(name = "EmployeeEntity.findByEmail", query = "SELECT e FROM EmployeeEntity e WHERE e.email = :email")})
public class EmployeeEntity {
	@Id
    @Column(name = "employee_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;
    @Column(name = "address", length = 255)
    private String address;
    @Column(name = "email", length = 255)
    private String email;
    @Column(name = "gender", length = 3)
    private String gender;
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Column(name = "phone_number", nullable = false, length = 10)
    private String phoneNumber;
    @OneToMany(mappedBy = "employeeId")
    private Collection<OrderEntity> ordersCollection;
    @JoinColumn(name = "account_id", referencedColumnName = "account_id")
    @OneToOne
    private AccountEntity accountId;
    
    public EmployeeEntity() {
    	super();
    }

    public EmployeeEntity(String name, String gender, String address, String phoneNumber, String email) {
		super();
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Collection<OrderEntity> getOrdersCollection() {
		return ordersCollection;
	}

	public void setOrdersCollection(Collection<OrderEntity> ordersCollection) {
		this.ordersCollection = ordersCollection;
	}

	public AccountEntity getAccountId() {
		return accountId;
	}

	public void setAccountId(AccountEntity accountId) {
		this.accountId = accountId;
	}

}
