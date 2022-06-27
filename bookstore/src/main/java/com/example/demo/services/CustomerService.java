package com.example.demo.services;


import org.springframework.http.ResponseEntity;

import com.example.demo.data.dto.CustomerDto;
import com.example.demo.data.entities.AccountEntity;
import com.example.demo.request.RegisterRequest;

public interface CustomerService {
	public ResponseEntity<?> addCustomer(RegisterRequest dto, AccountEntity account);
	public CustomerDto getCustomer(Integer customerId);
	public ResponseEntity<?> updateCustomer(Integer customerId, CustomerDto dto);
	public ResponseEntity<?> getOrders(Integer customerId);
}
