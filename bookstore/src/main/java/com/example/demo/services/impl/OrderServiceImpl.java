package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.data.entities.BookEntity;
import com.example.demo.data.entities.OrderDetailEntity;
import com.example.demo.data.entities.OrderEntity;
import com.example.demo.data.repositories.BookRepository;
import com.example.demo.data.repositories.OrderRepository;
import com.example.demo.dto.request.OrderDetailsRequestDto;
import com.example.demo.dto.request.OrderRequestDto;
import com.example.demo.dto.response.OrderResponseDto;
import com.example.demo.exceptions.ResourceFoundException;
import com.example.demo.payload.response.MessageResponse;
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
	public ResponseEntity<?> getOrdersOnDate(String date) {
		// TODO Auto-generated method stub
		List<OrderEntity> list = orderRepository.findOrdersOfDate(date);
		if(list.size()==0) {
			return ResponseEntity.ok(new MessageResponse("No orders on "+ date));
		}
		List<OrderResponseDto> listDto = new ArrayList<OrderResponseDto>();
		list.forEach(o -> listDto.add(modelMapper.map(o, OrderResponseDto.class)));
		return ResponseEntity.ok(listDto);
	}

	@Override
	public OrderResponseDto getOrder(Integer id) {
		// TODO Auto-generated method stub
		Optional<OrderEntity> optional = orderRepository.findById(id);
		if(!optional.isPresent()) {
			throw new ResourceFoundException("Order not found");
		}
		OrderEntity order = optional.get();
		return modelMapper.map(order, OrderResponseDto.class);
	}

	@Override
	@Transactional
	public ResponseEntity<?> addOrder(OrderRequestDto dto) {
		// TODO Auto-generated method stub
		OrderEntity order = modelMapper.map(dto, OrderEntity.class);
		
		for(OrderDetailsRequestDto detailDto : dto.getOrderDetails()) {
			OrderDetailEntity detail = new OrderDetailEntity(Integer.parseInt(detailDto.getQuantity()), Long.parseLong(detailDto.getUnitPrice()));
			Optional<BookEntity> optional = bookRepository.findById(Integer.parseInt(detailDto.getBookId()));
			if(!optional.isPresent()) {
				throw new ResourceFoundException("BookId : "+detailDto.getBookId()+" not found");
			}
			detail.setBookEntity(optional.get());
			order.getOrderDetailsCollection().add(detail);
		}
		order = orderRepository.save(order);
		return ResponseEntity.ok(new MessageResponse("The book was added successfully"));
	}

	@Override
	public ResponseEntity<?> confirmOrder(Integer id) {
		// TODO Auto-generated method stub
		Optional<OrderEntity> optional = orderRepository.findById(id);
		if(!optional.isPresent()) {
			throw new ResourceFoundException("Order not found");
		}
		
		OrderEntity order = optional.get();
		if(order.isConfirmed()) {
			return ResponseEntity.badRequest().body(new MessageResponse("The order has been confirmed before"));
		}
		order.setConfirmed(true);
		orderRepository.save(order);
		return ResponseEntity.ok(new MessageResponse("Confirm order successfully"));
	}

	@Override
	public ResponseEntity<?> getOrdersPending() {
		// TODO Auto-generated method stub
		List<OrderEntity> list = orderRepository.findOrdersPending();
		if(list.size()==0) {
			return ResponseEntity.ok(new MessageResponse("No pending orders"));
		}
		List<OrderResponseDto> listDto = new ArrayList<OrderResponseDto>();
		list.forEach(o -> listDto.add(modelMapper.map(o, OrderResponseDto.class)));
		return ResponseEntity.ok(listDto);
	}

}
