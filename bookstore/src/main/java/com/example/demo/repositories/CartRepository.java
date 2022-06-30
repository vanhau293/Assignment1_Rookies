package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.data.entities.CartEntity;
import com.example.demo.data.entities.CartPK;
@Repository
public interface CartRepository extends JpaRepository<CartEntity, CartPK>{
	public List<CartEntity> findByCustomerId(Integer customerId);
}
