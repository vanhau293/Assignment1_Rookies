package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.data.dto.OrderDetailsDto;
import com.example.demo.data.dto.OrderDto;
import com.example.demo.data.dto.StatusDto;
import com.example.demo.data.dto.UpdateOrderDto;
import com.example.demo.data.entities.OrderDetailEntity;
import com.example.demo.data.entities.OrderDetailPK;
import com.example.demo.data.entities.OrderEntity;
import com.example.demo.data.entities.StatusEntity;
import com.example.demo.repositories.OrderDetailRepository;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.repositories.StatusRepository;
import com.example.demo.response.MessageResponse;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.services.OrderService;
@Service
public class OrderServiceImpl implements OrderService{

	OrderRepository orderRepository;
	OrderDetailRepository orderDetailRepository;
	StatusRepository statusRepository;
	ModelMapper modelMapper;
	
	@Autowired
	public OrderServiceImpl(StatusRepository statusRepository, OrderRepository orderRepository, OrderDetailRepository orderDetailRepository, ModelMapper modelMapper) {
		// TODO Auto-generated constructor stub
		this.orderDetailRepository = orderDetailRepository;
		this.statusRepository = statusRepository;
		this.orderRepository = orderRepository;
		this.modelMapper = modelMapper;
	}
	
	@Override
	public ResponseEntity<?> getOrders(String date, Integer statusId) {
		// TODO Auto-generated method stub
		System.out.println(date);
		if(date == null && statusId == null) {
			return ResponseEntity.badRequest().body(new MessageResponse("Please enter param: date or statusId"));
		}
		List<OrderEntity> list = null;
		
		if(date == null)
			list = orderRepository.findOrdersWithStatus(statusId);
		else if(statusId == null) {
			String split[] = date.split("-"); // date dd/MM/yyyy
			list = orderRepository.findOrdersOnDate(Integer.parseInt(split[0]),Integer.parseInt(split[1]),Integer.parseInt(split[2]));
		}
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
	public OrderDto getOrderById(Integer id) {
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
		order = orderRepository.save(order);
		List<OrderDetailEntity> details = new ArrayList<>();
		OrderDetailEntity detail;
		for(OrderDetailsDto s : dto.getOrderDetails()) {
			detail = modelMapper.map(s, OrderDetailEntity.class);
			detail.setOrderDetailPK(new OrderDetailPK(order.getOrderId(), s.getBookEntity().bookId));
			details.add(detail);
		}
		orderDetailRepository.saveAll(details);
		return ResponseEntity.ok(new MessageResponse("The order was added successfully"));
	}

	@Override
	public ResponseEntity<?> updateOrder(Integer id, UpdateOrderDto dto) {
		// TODO Auto-generated method stub
		Optional<OrderEntity> optional = orderRepository.findById(id);
		if(!optional.isPresent()) {
			throw new ResourceNotFoundException("Order not found");
		}
		OrderEntity order = optional.get();
		order.setStatusId(null);
		modelMapper.map(dto, order);
		
		orderRepository.save(order);
		return ResponseEntity.ok(new MessageResponse("Update order successfully"));
	}

	@Override
	public ResponseEntity<?> getAllStatus() {
		// TODO Auto-generated method stub
		List<StatusEntity> list = statusRepository.findAll();
		List<StatusDto> listDto = new ArrayList<StatusDto>();
		list.forEach(s -> listDto.add(modelMapper.map(s, StatusDto.class)));
		
		return ResponseEntity.ok(listDto);
	}


}
