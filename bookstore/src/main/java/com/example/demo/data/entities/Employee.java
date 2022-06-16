package com.example.demo.data.entities;

import java.util.Collection;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "employee")
@Getter
@Setter
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")
    , @NamedQuery(name = "Employee.findByEmployeeId", query = "SELECT e FROM Employee e WHERE e.employeeId = :employeeId")
    , @NamedQuery(name = "Employee.findByPhoneNumber", query = "SELECT e FROM Employee e WHERE e.phoneNumber = :phoneNumber")
    , @NamedQuery(name = "Employee.findByEmail", query = "SELECT e FROM Employee e WHERE e.email = :email")})
public class Employee {
	@Id
    @Basic(optional = false)
    @Column(name = "employee_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "gender")
    private String gender;
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "email")
    private String email;
    @JoinColumn(name = "username", referencedColumnName = "username")
    @OneToOne
    private User username;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<GoodsReceived> goodsReceivedCollection;
    @OneToMany(mappedBy = "employeeId")
    private Collection<Order> orderCollection;
    
    public Employee() {
    	super();
    }

    public Employee(String name, String gender, String address, String phoneNumber, String email) {
		super();
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

}
