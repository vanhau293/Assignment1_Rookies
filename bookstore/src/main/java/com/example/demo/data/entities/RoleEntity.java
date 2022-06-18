package com.example.demo.data.entities;

import java.util.Collection;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "roles")
@Getter
@Setter
@NamedQueries({
    @NamedQuery(name = "RoleEntity.findAll", query = "SELECT r FROM RoleEntity r")
    , @NamedQuery(name = "RoleEntity.findByRoleId", query = "SELECT r FROM RoleEntity r WHERE r.roleId = :roleId")
    , @NamedQuery(name = "RoleEntity.findByRoleName", query = "SELECT r FROM RoleEntity r WHERE r.roleName = :roleName")})
public class RoleEntity {
	
	@Id
    @Column(name = "role_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;
    @Column(name = "role_name", length = 50)
    private String roleName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roleId")
    private Collection<AccountEntity> accountsCollection;
    
    public RoleEntity() {
    	super();
    }

    public RoleEntity(String roleName) {
    	super();
        this.roleName= roleName;
        
    }
}
