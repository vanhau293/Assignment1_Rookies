package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.data.entities.AccountEntity;
@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Integer>{
	public Optional<AccountEntity> findByUserName(String userName);
	//Boolean existsByUser_name(String username);
	
}
