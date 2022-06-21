package com.example.demo.data.entities;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "accounts", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"user_name"})})
@NamedQueries({
    @NamedQuery(name = "AccountEntity.findAll", query = "SELECT a FROM AccountEntity a")
    , @NamedQuery(name = "AccountEntity.findByAccountId", query = "SELECT a FROM AccountEntity a WHERE a.accountId = :accountId")
    , @NamedQuery(name = "AccountEntity.findByUserName", query = "SELECT a FROM AccountEntity a WHERE a.userName = :userName")})
public class AccountEntity {

	@Id
    @Column(name = "account_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;
    @Column(name = "user_name", nullable = false, length = 50)
    private String userName;
    @Column(name = "password", nullable = false, length = 100)
    private String password;
    @Column(name = "blocked", nullable = false)
    private boolean blocked;
    @JoinColumn(name = "role_id", referencedColumnName = "role_id", nullable = false)
    @ManyToOne(optional = false)
    private RoleEntity roleId;
    @OneToOne(mappedBy = "accountId")
    private CustomerEntity customerEntity;
    @OneToOne(mappedBy = "accountId")
    private EmployeeEntity employeeEntity;
    
    public AccountEntity() {
    }


    public AccountEntity( String userName, String password) {
        this.userName = userName;
        this.password = password;
    }


	public Integer getAccountId() {
		return accountId;
	}


	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public boolean isBlocked() {
		return blocked;
	}


	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}


	public RoleEntity getRoleId() {
		return roleId;
	}


	public void setRoleId(RoleEntity roleId) {
		this.roleId = roleId;
	}


	public CustomerEntity getCustomerEntity() {
		return customerEntity;
	}


	public void setCustomerEntity(CustomerEntity customerEntity) {
		this.customerEntity = customerEntity;
	}


	public EmployeeEntity getEmployeeEntity() {
		return employeeEntity;
	}


	public void setEmployeeEntity(EmployeeEntity employeeEntity) {
		this.employeeEntity = employeeEntity;
	}
    
}