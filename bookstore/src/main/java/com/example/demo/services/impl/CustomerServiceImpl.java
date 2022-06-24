package com.example.demo.services.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.data.entities.AccountEntity;
import com.example.demo.data.entities.CustomerEntity;
import com.example.demo.data.repositories.CustomerRepository;
import com.example.demo.dto.request.RegisterRequestDto;
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

}
