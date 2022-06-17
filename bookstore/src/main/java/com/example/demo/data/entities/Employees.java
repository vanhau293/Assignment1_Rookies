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
    @NamedQuery(name = "Employees.findAll", query = "SELECT e FROM Employees e")
    , @NamedQuery(name = "Employees.findByEmployeeId", query = "SELECT e FROM Employees e WHERE e.employeeId = :employeeId")
    , @NamedQuery(name = "Employees.findByPhoneNumber", query = "SELECT e FROM Employees e WHERE e.phoneNumber = :phoneNumber")
    , @NamedQuery(name = "Employees.findByEmail", query = "SELECT e FROM Employees e WHERE e.email = :email")})
public class Employees {
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
    private Collection<Orders> ordersCollection;
    @JoinColumn(name = "account_id", referencedColumnName = "account_id")
    @OneToOne
    private Accounts accountId;
    
    public Employees() {
    	super();
    }

    public Employees(String name, String gender, String address, String phoneNumber, String email) {
		super();
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

}
