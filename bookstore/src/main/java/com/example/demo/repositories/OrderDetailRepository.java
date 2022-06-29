package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.data.entities.OrderDetailEntity;
import com.example.demo.data.entities.OrderDetailPK;
@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, OrderDetailPK>{

}
