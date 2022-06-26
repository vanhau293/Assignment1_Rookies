package com.example.demo.data.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.data.entities.OrderEntity;
@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer>{
	public List<OrderEntity> findOrdersOfDate(String date);
	public List<OrderEntity> findOrdersPending();
	public OrderEntity findByOrderId(Integer id);
	public List<OrderEntity> findAll();
}
