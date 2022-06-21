package com.example.demo.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.data.entities.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer>{
	public RoleEntity findByRoleName(String roleName);
}
