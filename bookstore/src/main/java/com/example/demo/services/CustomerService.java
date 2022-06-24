package com.example.demo.services;

import org.springframework.http.ResponseEntity;

import com.example.demo.data.entities.AccountEntity;
import com.example.demo.dto.request.RegisterRequestDto;

public interface CustomerService {
	public ResponseEntity<?> addCustomer(RegisterRequestDto dto, AccountEntity account);
}
