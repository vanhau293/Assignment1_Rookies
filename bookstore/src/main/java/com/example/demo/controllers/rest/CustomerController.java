package com.example.demo.controllers.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.request.CustomerRequestDto;
import com.example.demo.dto.response.CustomerResponseDto;
import com.example.demo.dto.response.OrderResponseDto;
import com.example.demo.services.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
	CustomerService customerService;
		
	@GetMapping("/{id}")
	public CustomerResponseDto getCustomer(@PathVariable Integer customerId){
		return customerService.getCustomer(customerId);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateCustomer(@PathVariable Integer customerId, 
			@Valid @RequestBody CustomerRequestDto dto){
		return customerService.updateCustomer(customerId, dto);
	}
	@GetMapping("/{id}/orders")
	public List<OrderResponseDto> getOrders(@PathVariable Integer id){
		return customerService.getOrders(id);
	}
}
