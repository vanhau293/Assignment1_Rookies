package com.example.demo.services.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.data.dto.AccountUpdateDto;
import com.example.demo.data.entities.AccountEntity;
import com.example.demo.data.entities.RoleEntity;
import com.example.demo.repositories.AccountRepository;
import com.example.demo.repositories.RoleRepository;
import com.example.demo.request.RegisterRequest;
import com.example.demo.response.MessageResponse;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.services.AccountService;
@Service
public class AccountServiceImpl implements AccountService{

	
	private AccountRepository accountRepository;
	private RoleRepository roleRepository;
	private ModelMapper modelMapper;
	
	@Autowired
	public AccountServiceImpl(AccountRepository accountRepository, RoleRepository roleRepository, ModelMapper modelMapper) {
		this.accountRepository = accountRepository;
		this.roleRepository = roleRepository;
		this.modelMapper = modelMapper;
	}
	@Override
	public AccountEntity addAccount(RegisterRequest dto) {
		// TODO Auto-generated method stub
		Optional<AccountEntity> optional = accountRepository.findByUserName(dto.getUserName());
		if(optional.isPresent()) {
			throw new IllegalArgumentException("Username is already taken!");
		}
		AccountEntity account = modelMapper.map(dto, AccountEntity.class);
		Optional<RoleEntity> roleOptional = roleRepository.findByRoleName("Customer");
		if(!roleOptional.isPresent()) {
			throw new ResourceNotFoundException("Role name not found");
		}
		RoleEntity role = roleOptional.get();
		account.setRoleId(role);
		account = accountRepository.save(account);
		return account;
	}

	@Override
	public ResponseEntity<?> updateAccount(AccountUpdateDto dto, Integer accountId) {
		// TODO Auto-generated method stub
		Optional<AccountEntity> optional = accountRepository.findById(accountId);
		if(!optional.isPresent()) {
			throw new ResourceNotFoundException("Account is not found");
		}
		AccountEntity account = optional.get();
		account.setPassword(dto.getPassword());
		accountRepository.save(account);
		
		return ResponseEntity.ok(new MessageResponse("Update password successfully"));
	}

	@Override
	public ResponseEntity<?> blockAccount(Integer accountId) {
		// TODO Auto-generated method stub
		Optional<AccountEntity> optional = accountRepository.findById(accountId);
		if(!optional.isPresent()) {
			throw new ResourceNotFoundException("Account is not found");
		}
		AccountEntity account = optional.get();
		if(account.isBlocked()) {
			return ResponseEntity.badRequest().body(new MessageResponse("The account has been deleted before")) ;
		}
		account.setBlocked(true);
		return ResponseEntity.ok(new MessageResponse("The account blocked successfully"));
	}

}
