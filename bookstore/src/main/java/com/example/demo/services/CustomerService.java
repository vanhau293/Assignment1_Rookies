package com.example.demo.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.data.entities.AccountEntity;
import com.example.demo.dto.request.CustomerRequestDto;
import com.example.demo.dto.request.RegisterRequestDto;
import com.example.demo.dto.response.CustomerResponseDto;
import com.example.demo.dto.response.OrderResponseDto;

public interface CustomerService {
	public ResponseEntity<?> addCustomer(RegisterRequestDto dto, AccountEntity account);
	public CustomerResponseDto getCustomer(Integer customerId);
	public ResponseEntity<?> updateCustomer(Integer customerId, CustomerRequestDto dto);
	public List<OrderResponseDto> getOrders(Integer customerId);
}
