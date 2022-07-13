package com.example.demo.controllers.rest;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.dto.CartDto;
import com.example.demo.data.dto.CustomerDto;
import com.example.demo.services.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
	CustomerService customerService;
		
	@GetMapping("/{id}")
	public CustomerDto getCustomerById(@PathVariable Integer id){
		return customerService.getCustomer(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateCustomer(@PathVariable Integer id, 
			@Valid @RequestBody CustomerDto dto){
		return customerService.updateCustomer(id, dto);
	}
	@GetMapping("/{id}/orders")
	public ResponseEntity<?> getOrders(@PathVariable Integer id){
		return customerService.getOrders(id);
	}
	@GetMapping("/{id}/cart")
	public ResponseEntity<?> getCartByCustomerId(@PathVariable Integer id){
		return customerService.getCartByCustomerId(id);
	}
	@PostMapping("/cart")
	public ResponseEntity<?> addCart(@Valid @RequestBody CartDto dto){
		return customerService.addCart(dto);
	}
	@PutMapping("/cart")
	public ResponseEntity<?> updateCart(@Valid @RequestBody CartDto dto){
		return customerService.updateCart(dto);
	}
	@DeleteMapping("/{id}/cart")
	public ResponseEntity<?> deleteCart(@PathVariable Integer id){
		return customerService.deleteCart(id);
	}
}
