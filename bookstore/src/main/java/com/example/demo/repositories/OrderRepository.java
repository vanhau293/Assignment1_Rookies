package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.data.entities.OrderEntity;
@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer>{
	public List<OrderEntity> findOrdersWithStatus(Integer statusId);
	public List<OrderEntity> findOrdersOnDate(Integer day, Integer month, Integer year);
	public List<OrderEntity> findOrders(Integer day, Integer month, Integer year, Integer statusId);
	public OrderEntity findByOrderId(Integer id);
	public List<OrderEntity> findAll();
}
