package com.example.demo.services;


import org.springframework.http.ResponseEntity;

import com.example.demo.data.dto.OrderDto;
import com.example.demo.data.dto.UpdateOrderDto;

public interface OrderService {
	public ResponseEntity<?> getOrders(String date,Integer statusId);
	
	public OrderDto getOrderById(Integer id);
	public ResponseEntity<?> addOrder(OrderDto dto);
	public ResponseEntity<?> updateOrder(Integer id, UpdateOrderDto dto);
}
