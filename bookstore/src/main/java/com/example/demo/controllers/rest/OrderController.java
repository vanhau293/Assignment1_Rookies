package com.example.demo.controllers.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.request.OrderRequestDto;
import com.example.demo.dto.response.OrderResponseDto;
import com.example.demo.services.OrderService;


@RestController
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	OrderService orderService;
	
	@GetMapping("/on/{date}")
	public ResponseEntity<?> getOrderOnDate(@PathVariable String date){
		return orderService.getOrdersOnDate(date);
	}
	
	@GetMapping("/{id}")
	public OrderResponseDto getOrder(@PathVariable Integer id){
		return orderService.getOrder(id);
	}
	
	@PostMapping("")
	public ResponseEntity<?> addOrder(@Valid @RequestBody OrderRequestDto dto){
		System.out.println("hi");
		return orderService.addOrder(dto);
	}
	
	@GetMapping("/pending")
	public ResponseEntity<?> getOrdersPending(){
		return orderService.getOrdersPending();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> confirmOrder(@PathVariable Integer id){
		return orderService.confirmOrder(id);
	}
	
}
