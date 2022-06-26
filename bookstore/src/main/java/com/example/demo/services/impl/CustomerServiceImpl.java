package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.data.entities.AccountEntity;
import com.example.demo.data.entities.CustomerEntity;
import com.example.demo.data.repositories.CustomerRepository;
import com.example.demo.dto.request.CustomerRequestDto;
import com.example.demo.dto.request.RegisterRequestDto;
import com.example.demo.dto.response.CustomerResponseDto;
import com.example.demo.dto.response.OrderResponseDto;
import com.example.demo.exceptions.ResourceFoundException;
import com.example.demo.payload.response.MessageResponse;
import com.example.demo.services.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService{
	private CustomerRepository customerRepository;
	private ModelMapper modelMapper;
	
	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper) {
		this.customerRepository = customerRepository;
		this.modelMapper = modelMapper;
	}
	
	@Override
	public ResponseEntity<?> addCustomer(RegisterRequestDto dto, AccountEntity account) {
		// TODO Auto-generated method stub
		Optional<CustomerEntity> optional = customerRepository.findByPhoneNumber(dto.getPhoneNumber());
		if(optional.isPresent()) {
			throw new IllegalArgumentException("Phone number is already taken");
		}
		CustomerEntity customer = modelMapper.map(dto, CustomerEntity.class);
		customer.setAccountId(account);
		customerRepository.save(customer);
		return ResponseEntity.ok(new MessageResponse("Sign up successfully !!!"));
	}

	@Override
	public ResponseEntity<?> updateCustomer(Integer customerId, CustomerRequestDto dto) {
		// TODO Auto-generated method stub
		Optional<CustomerEntity> optional = customerRepository.findById(customerId);
		if(!optional.isPresent()) {
			throw new ResourceFoundException("Customer not found");
		}
		CustomerEntity customer = optional.get();
		if(!customer.getPhoneNumber().equals(dto.getPhoneNumber())) {
			Optional<CustomerEntity> optional2 = customerRepository.findByPhoneNumber(dto.getPhoneNumber());
			if(optional2.isPresent()) {
				throw new IllegalArgumentException("Phone number is already taken");
			}
		}
		
		modelMapper.map(dto, customer);
		customerRepository.save(customer);
		return ResponseEntity.ok(new MessageResponse("Update Customer successfully !"));
	}

	@Override
	public CustomerResponseDto getCustomer(Integer customerId) {
		// TODO Auto-generated method stub
		Optional<CustomerEntity> optional = customerRepository.findById(customerId);
		if(!optional.isPresent()) {
			throw new ResourceFoundException("Customer not found");
		}
		CustomerEntity customer = optional.get();
		
		return modelMapper.map(customer, CustomerResponseDto.class);
	}

	@Override
	public List<OrderResponseDto> getOrders(Integer customerId) {
		// TODO Auto-generated method stub
		Optional<CustomerEntity> optional = customerRepository.findById(customerId);
		if(!optional.isPresent()) {
			throw new ResourceFoundException("Customer not found");
		}
		CustomerEntity customer = optional.get();
		if(customer.getOrdersCollection().size() == 0) {
			throw new ResourceFoundException("Customer don't have orders");
		}
		List<OrderResponseDto> list = new ArrayList<OrderResponseDto>();
		customer.getOrdersCollection().forEach(order -> list.add(modelMapper.map(order, OrderResponseDto.class)));
		return null;
	}

}
