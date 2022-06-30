package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.data.dto.CartDto;
import com.example.demo.data.dto.CustomerDto;
import com.example.demo.data.dto.OrderDto;
import com.example.demo.data.entities.AccountEntity;
import com.example.demo.data.entities.BookEntity;
import com.example.demo.data.entities.CartEntity;
import com.example.demo.data.entities.CustomerEntity;
import com.example.demo.repositories.BookRepository;
import com.example.demo.repositories.CartRepository;
import com.example.demo.repositories.CustomerRepository;
import com.example.demo.request.RegisterRequest;
import com.example.demo.response.MessageResponse;
import com.example.demo.services.CustomerService;
import com.example.demo.exceptions.ResourceNotFoundException;
@Service
public class CustomerServiceImpl implements CustomerService{
	private CustomerRepository customerRepository;
	private CartRepository cartRepository;
	private BookRepository bookRepository;
	private ModelMapper modelMapper;
	
	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository, BookRepository bookRepository, CartRepository cartRepository, ModelMapper modelMapper) {
		this.customerRepository = customerRepository;
		this.bookRepository = bookRepository;
		this.cartRepository = cartRepository;
		this.modelMapper = modelMapper;
	}
	
	@Override
	public ResponseEntity<?> addCustomer(RegisterRequest dto, AccountEntity account) {
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
	public ResponseEntity<?> updateCustomer(Integer customerId, CustomerDto dto) {
		// TODO Auto-generated method stub
		Optional<CustomerEntity> optional = customerRepository.findById(customerId);
		if(!optional.isPresent()) {
			throw new ResourceNotFoundException("Customer not found");
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
	public CustomerDto getCustomer(Integer customerId) {
		// TODO Auto-generated method stub
		Optional<CustomerEntity> optional = customerRepository.findById(customerId);
		if(!optional.isPresent()) {
			throw new ResourceNotFoundException("Customer not found");
		}
		CustomerEntity customer = optional.get();
		
		return modelMapper.map(customer, CustomerDto.class);
	}

	@Override
	public ResponseEntity<?> getOrders(Integer customerId) {
		// TODO Auto-generated method stub
		Optional<CustomerEntity> optional = customerRepository.findById(customerId);
		if(!optional.isPresent()) {
			throw new ResourceNotFoundException("Customer not found");
		}
		CustomerEntity customer = optional.get();
		if(customer.getOrdersCollection().size() == 0) {
			return ResponseEntity.ok("Customer don't have orders");
		}
		List<OrderDto> list = new ArrayList<OrderDto>();
		customer.getOrdersCollection().forEach(order -> list.add(modelMapper.map(order, OrderDto.class)));
		return ResponseEntity.ok(list);
	}

	@Override
	public ResponseEntity<?> getCartByCustomerId(Integer customerId) {
		// TODO Auto-generated method stub
		Optional<CustomerEntity> optionalCustomer = customerRepository.findById(customerId);
		if(!optionalCustomer.isPresent()) {
			throw new ResourceNotFoundException("Customer not found");
		}
		List<CartEntity> list = customerRepository.findCartByCustomerId(customerId);
		List<CartDto> dto = new ArrayList<CartDto>();
		list.forEach(c -> dto.add(modelMapper.map(c, CartDto.class)));
		return ResponseEntity.ok(dto);
	}

	@Override
	public ResponseEntity<?> addCart(CartDto dto) {
		// TODO Auto-generated method stub
		Optional<BookEntity> optionalBook = bookRepository.findById(dto.getCartPK().getBookId());
		if(!optionalBook.isPresent()) {
			return ResponseEntity.badRequest().body(new MessageResponse("BookId of CartPK not found"));
		}
		Optional<CustomerEntity> optionalCustomer = customerRepository.findById(dto.getCartPK().getCustomerId());
		if(!optionalCustomer.isPresent()) {
			return ResponseEntity.badRequest().body(new MessageResponse("CustomerId of CartPK not found"));
		}
		Optional<CartEntity> optionalCart = cartRepository.findById(dto.getCartPK());
		if(optionalCart.isPresent()) {
			CartEntity cart = optionalCart.get();
			cart.setQuantity(cart.getQuantity()+Integer.parseInt(dto.getQuantity()));
			cartRepository.save(cart);
		}
		else cartRepository.save(modelMapper.map(dto, CartEntity.class));
		
		return ResponseEntity.ok(new MessageResponse("Cart is added successfully"));
	}

	@Override
	public ResponseEntity<?> updateCart(CartDto dto) {
		// TODO Auto-generated method stub
		Optional<BookEntity> optionalBook = bookRepository.findById(dto.getCartPK().getBookId());
		if(!optionalBook.isPresent()) {
			return ResponseEntity.badRequest().body(new MessageResponse("BookId of CartPK not found"));
		}
		Optional<CustomerEntity> optionalCustomer = customerRepository.findById(dto.getCartPK().getCustomerId());
		if(!optionalCustomer.isPresent()) {
			return ResponseEntity.badRequest().body(new MessageResponse("CustomerId of CartPK not found"));
		}
		Optional<CartEntity> optional = cartRepository.findById(dto.getCartPK());
		if(optional.isPresent()) {
			CartEntity cart = optional.get();
			if(Integer.parseInt(dto.getQuantity()) == 0) {
				cartRepository.delete(cart);
				return ResponseEntity.ok(new MessageResponse("Cart is updated successfully"));
			}
			cart.setQuantity(Integer.parseInt(dto.getQuantity()));
			cartRepository.save(cart);
			return ResponseEntity.ok(new MessageResponse("Cart is updated successfully"));
		}
		throw new ResourceNotFoundException("CartPK not found");
	}

	@Override
	public ResponseEntity<?> deleteCart(Integer customerId) {
		// TODO Auto-generated method stub
		Optional<CustomerEntity> optionalCustomer = customerRepository.findById(customerId);
		if(!optionalCustomer.isPresent()) {
			throw new ResourceNotFoundException("Customer not found");
		}
		List<CartEntity> list = cartRepository.findByCustomerId(customerId);
		cartRepository.deleteAll(list);
		return ResponseEntity.ok(new MessageResponse("Deleted successfully"));
	}

}
