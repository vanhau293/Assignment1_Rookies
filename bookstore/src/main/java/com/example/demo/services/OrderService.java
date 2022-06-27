package com.example.demo.services;


import org.springframework.http.ResponseEntity;

import com.example.demo.data.dto.OrderDto;

public interface OrderService {
	public ResponseEntity<?> getOrders(String date,Integer statusId);
	
	public OrderDto getOrder(Integer id);
	public ResponseEntity<?> addOrder(OrderDto dto);
	public ResponseEntity<?> confirmOrder(Integer id);
	
}
