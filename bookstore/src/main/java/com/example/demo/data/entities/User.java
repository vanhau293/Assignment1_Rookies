package com.example.demo.data.entities;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "user")
@Getter
@Setter
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
    , @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username")})
public class User {
	@Id
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @OneToOne(mappedBy = "username")
    private Employee employee;
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    @ManyToOne(optional = false)
    private Role roleId;
    @OneToOne(mappedBy = "username")
    private Customer customer;
    
    public User() {
    	super();
    }

    public User(String username) {
    	super();
        this.username = username;
    }

    public User(String username, String password) {
    	super();
        this.username = username;
        this.password = password;
    }
}
