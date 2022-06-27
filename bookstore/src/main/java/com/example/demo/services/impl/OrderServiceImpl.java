package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.data.dto.OrderDto;
import com.example.demo.data.entities.OrderEntity;
import com.example.demo.repositories.BookRepository;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.response.MessageResponse;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.services.OrderService;
@Service
public class OrderServiceImpl implements OrderService{

	OrderRepository orderRepository;
	BookRepository bookRepository;
	ModelMapper modelMapper;
	
	@Autowired
	public OrderServiceImpl(BookRepository bookRepository, OrderRepository orderRepository, ModelMapper modelMapper) {
		// TODO Auto-generated constructor stub
		this.bookRepository = bookRepository;
		this.orderRepository = orderRepository;
		this.modelMapper = modelMapper;
	}
	
	@Override
	public ResponseEntity<?> getOrders(String date, Integer statusId) {
		// TODO Auto-generated method stub
		if(date == null && statusId == null) {
			return ResponseEntity.badRequest().body(new MessageResponse("Please enter param: date or statusId"));
		}
		List<OrderEntity> list = null;
		
		if(date == null)
			list = orderRepository.findOrdersWithStatus(statusId);
		else if(statusId == null)
			list = orderRepository.findOrdersOnDate(date);
		else 
			list = orderRepository.findOrders(date, statusId);
		
		if(list.size()==0) {
			return ResponseEntity.ok(new MessageResponse("No orders on "+ date +" with statusId: "+statusId));
		}
		List<OrderDto> listDto = new ArrayList<OrderDto>();
		list.forEach(o -> listDto.add(modelMapper.map(o, OrderDto.class)));
		return ResponseEntity.ok(listDto);
	}

	@Override
	public OrderDto getOrder(Integer id) {
		// TODO Auto-generated method stub
		Optional<OrderEntity> optional = orderRepository.findById(id);
		if(!optional.isPresent()) {
			throw new ResourceNotFoundException("Order not found");
		}
		OrderEntity order = optional.get();
		return modelMapper.map(order, OrderDto.class);
	}

	@Override
	@Transactional
	public ResponseEntity<?> addOrder(OrderDto dto) {
		// TODO Auto-generated method stub
		OrderEntity order = modelMapper.map(dto, OrderEntity.class);
		
//		for(OrderDetailsDto detailDto : dto.getOrderDetails()) {
//			OrderDetailEntity detail = new OrderDetailEntity(Integer.parseInt(detailDto.getQuantity()), Long.parseLong(detailDto.getUnitPrice()));
//			Optional<BookEntity> optional = bookRepository.findById(Integer.parseInt(detailDto.getBookId()));
//			if(!optional.isPresent()) {
//				throw new ResourceNotFoundException("BookId : "+detailDto.getBookId()+" not found");
//			}
//			detail.setBookEntity(optional.get());
//			order.getOrderDetailsCollection().add(detail);
//		}
		order = orderRepository.save(order);
		return ResponseEntity.ok(new MessageResponse("The book was added successfully"));
	}

	@Override
	public ResponseEntity<?> confirmOrder(Integer id) {
		// TODO Auto-generated method stub
		Optional<OrderEntity> optional = orderRepository.findById(id);
		if(!optional.isPresent()) {
			throw new ResourceNotFoundException("Order not found");
		}
		
//		OrderEntity order = optional.get();
//		if(order.isConfirmed()) {
//			return ResponseEntity.badRequest().body(new MessageResponse("The order has been confirmed before"));
//		}
//		order.setConfirmed(true);
//		orderRepository.save(order);
		return ResponseEntity.ok(new MessageResponse("Confirm order successfully"));
	}

//	@Override
//	public ResponseEntity<?> getOrdersPending() {
//		// TODO Auto-generated method stub
//		List<OrderEntity> list = orderRepository.findOrdersPending();
//		if(list.size()==0) {
//			return ResponseEntity.ok(new MessageResponse("No pending orders"));
//		}
//		List<OrderResponseDto> listDto = new ArrayList<OrderResponseDto>();
//		list.forEach(o -> listDto.add(modelMapper.map(o, OrderResponseDto.class)));
//		return ResponseEntity.ok(listDto);
//	}

}
