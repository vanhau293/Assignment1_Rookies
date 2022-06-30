package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.data.entities.OrderEntity;
import com.example.demo.data.entities.StatusEntity;
@Repository
public interface StatusRepository extends JpaRepository<StatusEntity, Integer>{
	public List<OrderEntity> findOrdersByStatus(String statusName);
}
