package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.data.entities.CartEntity;
import com.example.demo.data.entities.CustomerEntity;
@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer>{
	public Optional<CustomerEntity> findByPhoneNumber(String phoneNumber);
	public List<CartEntity> findCartByCustomerId(Integer customerId);
}
