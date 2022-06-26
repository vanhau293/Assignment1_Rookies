package com.example.demo.services;


import org.springframework.http.ResponseEntity;

import com.example.demo.dto.request.OrderRequestDto;
import com.example.demo.dto.response.OrderResponseDto;

public interface OrderService {
	public ResponseEntity<?> getOrdersOnDate(String date);
	
	public OrderResponseDto getOrder(Integer id);
	public ResponseEntity<?> addOrder(OrderRequestDto dto);
	public ResponseEntity<?> getOrdersPending();
	public ResponseEntity<?> confirmOrder(Integer id);
	
}
