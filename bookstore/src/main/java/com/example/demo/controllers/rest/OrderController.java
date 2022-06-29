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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.dto.OrderDto;
import com.example.demo.data.dto.UpdateOrderDto;
import com.example.demo.services.OrderService;


@RestController
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	OrderService orderService;
	
	@GetMapping("")
	public ResponseEntity<?> getOrders(@RequestParam(value = "date", required = false) String date, 
			@RequestParam(value = "status", required = false) Integer statusId){
		return orderService.getOrders(date, statusId);
	}
	
	@GetMapping("/{id}")
	public OrderDto getOrder(@PathVariable Integer id){
		return orderService.getOrderById(id);
	}
	
	@PostMapping("")
	public ResponseEntity<?> addOrder(@Valid @RequestBody OrderDto dto){
		System.out.println("hi");
		return orderService.addOrder(dto);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateOrder(@PathVariable Integer id, @Valid @RequestBody UpdateOrderDto dto){
		return orderService.updateOrder(id, dto);
	}
	
}
