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
    @NamedQuery(name = "Accounts.findAll", query = "SELECT a FROM Accounts a")
    , @NamedQuery(name = "Accounts.findByAccountId", query = "SELECT a FROM Accounts a WHERE a.accountId = :accountId")
    , @NamedQuery(name = "Accounts.findByUserName", query = "SELECT a FROM Accounts a WHERE a.userName = :userName")})
public class Accounts {

	@Id
    @Column(name = "account_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;
    @Column(name = "user_name", nullable = false, length = 50)
    private String userName;
    @Column(name = "password", nullable = false, length = 100)
    private String password;
    @JoinColumn(name = "role_id", referencedColumnName = "role_id", nullable = false)
    @ManyToOne(optional = false)
    private Roles roleId;
    @OneToOne(mappedBy = "accountId")
    private Customers customers;
    @OneToOne(mappedBy = "accountId")
    private Employees employees;
    
    public Accounts() {
    }


    public Accounts(Integer accountId, String userName, String password) {
        this.accountId = accountId;
        this.userName = userName;
        this.password = password;
    }
}