package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.data.dto.CartDto;
import com.example.demo.data.dto.OrderDto;
import com.example.demo.data.dto.StatusDto;
import com.example.demo.data.dto.UpdateOrderDto;
import com.example.demo.data.entities.BookEntity;
import com.example.demo.data.entities.CartEntity;
import com.example.demo.data.entities.EmployeeEntity;
import com.example.demo.data.entities.OrderDetailEntity;
import com.example.demo.data.entities.OrderDetailPK;
import com.example.demo.data.entities.OrderEntity;
import com.example.demo.data.entities.StatusEntity;
import com.example.demo.repositories.BookRepository;
import com.example.demo.repositories.CartRepository;
import com.example.demo.repositories.EmployeeRepository;
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
	EmployeeRepository employeeRepository;
	CartRepository cartRepository;
	BookRepository bookRepository;
	ModelMapper modelMapper;
	
	@Autowired
	public OrderServiceImpl(StatusRepository statusRepository, BookRepository bookRepository,CartRepository cartRepository, EmployeeRepository employeeRepository,
			OrderRepository orderRepository, OrderDetailRepository orderDetailRepository, ModelMapper modelMapper) {
		// TODO Auto-generated constructor stub
		this.orderDetailRepository = orderDetailRepository;
		this.statusRepository = statusRepository;
		this.orderRepository = orderRepository;
		this.bookRepository = bookRepository;
		this.cartRepository = cartRepository;
		this.employeeRepository = employeeRepository;
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
		Optional<StatusEntity> optionalStatus = statusRepository.findById(1);
		if(!optionalStatus.isPresent()) {
			throw new ResourceNotFoundException("Status 1 not found");
		}
		long totalCash = 0;
		order.setStatusId(optionalStatus.get());
		order.setUpdateDate(new Date());
		order = orderRepository.save(order);
		List<OrderDetailEntity> details = new ArrayList<>();
		OrderDetailEntity detail;
		for(CartDto s : dto.getListCart()) {
			Integer bookId = s.getCartPK().getBookId();
			Optional<BookEntity> optionalBook = bookRepository.findById(bookId);
			if(!optionalBook.isPresent()) {
				throw new ResourceNotFoundException("BookId: " + bookId + " not found");
			}
			detail = modelMapper.map(s, OrderDetailEntity.class);
			detail.setOrderDetailPK(new OrderDetailPK(order.getOrderId(),bookId));
			detail.setUnitPrice(optionalBook.get().getPrice());
			totalCash += (optionalBook.get().getPrice()*Integer.parseInt(s.getQuantity()));
			details.add(detail);
			cartRepository.delete(modelMapper.map(s, CartEntity.class));
		}
		order.setTotalCash(totalCash);
		orderRepository.save(order);
		orderDetailRepository.saveAll(details);
		return ResponseEntity.ok(new MessageResponse("The order was added successfully"));
	}

	@Override
	public ResponseEntity<?> updateOrder(Integer id, UpdateOrderDto dto) {
		// TODO Auto-generated method stub
		Optional<OrderEntity> optionalOrder = orderRepository.findById(id);
		if(!optionalOrder.isPresent()) {
			throw new ResourceNotFoundException("Order not found");
		}
		Optional<StatusEntity> optionalStatus = statusRepository.findById(dto.getStatusId().getStatusId());
		if(optionalStatus.isPresent()) {
			throw new ResourceNotFoundException("StatusId not found");
		}
		Optional<EmployeeEntity> optionalEmployee = employeeRepository.findById(Integer.parseInt(dto.getEmployeeId().getEmployeeId()));
		if(optionalEmployee.isPresent()) {
			throw new ResourceNotFoundException("EmployId not found");
		}
		OrderEntity order = optionalOrder.get();
		if(order.getStatusId().getStatusId()==1 && 
				(dto.getStatusId().getStatusId()==2 || dto.getStatusId().getStatusId()==3)) {// chỉ được cập nhật khi đang chờ xác nhận
			order.setStatusId(null);
			order.setEmployeeId(null);
			modelMapper.map(dto, order);

			order.setUpdateDate(new Date());
			orderRepository.save(order);
			return ResponseEntity.ok(new MessageResponse("Update order successfully"));
		}
		return ResponseEntity.badRequest().body(new MessageResponse("Updates are not allowed once the order has been confirmed or canceled"));
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
