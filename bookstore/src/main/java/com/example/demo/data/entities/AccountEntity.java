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


    public AccountEntity(Integer accountId, String userName, String password) {
        this.accountId = accountId;
        this.userName = userName;
        this.password = password;
    }
}