package com.example.demo.data.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.data.entities.RoleEntity;
@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Integer>{
	public Optional<RoleEntity> findByRoleName(String roleName);
}
