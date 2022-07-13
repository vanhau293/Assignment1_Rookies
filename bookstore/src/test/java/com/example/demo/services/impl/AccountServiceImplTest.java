package com.example.demo.services.impl;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.data.dto.AccountUpdateDto;
import com.example.demo.data.entities.AccountEntity;
import com.example.demo.data.entities.RoleEntity;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repositories.AccountRepository;
import com.example.demo.repositories.RoleRepository;
import com.example.demo.request.RegisterRequest;

public class AccountServiceImplTest {
	private AccountServiceImpl accountServiceImpl;
	private AccountRepository accountRepository;
	private RoleRepository roleRepository;
	private ModelMapper modelMapper;
	private AccountEntity initialAccount;
	private AccountEntity expectedAccount;
	private RegisterRequest dto;
	private RoleEntity role;
	private AccountUpdateDto dtoUpdate;
	private PasswordEncoder encoder;
	
	
	@BeforeEach
	public void beforeEach() {
		
		accountRepository = mock(AccountRepository.class);
		roleRepository = mock(RoleRepository.class);
		modelMapper = new ModelMapper();
		dtoUpdate = new AccountUpdateDto();
		encoder = mock(PasswordEncoder.class);
		accountServiceImpl = new AccountServiceImpl(accountRepository, roleRepository, encoder, modelMapper);
		initialAccount = mock(AccountEntity.class);
		dto = new RegisterRequest();
		role = new RoleEntity();
		when(accountRepository.save(initialAccount)).thenReturn(expectedAccount);
		
	}
	
	@Test
	public void addAccount_ShouldReturnAccountEntity_WhenDataValid() {
		when(roleRepository.findByRoleName("Customer")).thenReturn(Optional.of(role));
		when(accountRepository.findByUserName(dto.getName())).thenReturn(Optional.empty());
		AccountEntity result = accountServiceImpl.addAccount(dto);
		assertThat(result, is(expectedAccount));
	}
	@Test
	public void addAccount_ShouldThrowIllegalArgumentException_WhenUserNameTaken() {
		when(roleRepository.findByRoleName("Customer")).thenReturn(Optional.of(role));
		when(accountRepository.findByUserName(dto.getName())).thenReturn(Optional.of(initialAccount));
		IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> accountServiceImpl.addAccount(dto));
        assertThat(exception.getMessage(), is("Username is already taken!"));
	}
	@Test
	public void addAccount_ShouldThrowResourceNotFoundException_WhenUserNameNotFound() {
		when(accountRepository.findByUserName(dto.getName())).thenReturn(Optional.empty());
		when(roleRepository.findByRoleName("Customer")).thenReturn(Optional.empty());
		ResourceNotFoundException exception = Assertions.assertThrows(ResourceNotFoundException.class, 
				() -> accountServiceImpl.addAccount(dto));
        assertThat(exception.getMessage(), is("Role name not found"));
	}
	@Test
	public void  updateAccount_ShouldReturnHttpOk_WhenDataValid() {
		when(accountRepository.findById(1)).thenReturn(Optional.of(initialAccount));
		ResponseEntity<?> result = accountServiceImpl.updateAccount(dtoUpdate,1);
		verify(initialAccount).setPassword(dto.getPassword());
		assertThat(result.getStatusCode(), is(HttpStatus.OK));
		
	}
	@Test
	public void  updateAccount_ShouldThrowResourceNotFoundException_WhenAccountIdNotFound() {
		when(accountRepository.findById(1)).thenReturn(Optional.empty());
		ResourceNotFoundException exception = Assertions.assertThrows(ResourceNotFoundException.class, 
				() -> accountServiceImpl.updateAccount(dtoUpdate, 1));
        assertThat(exception.getMessage(), is("Account not found"));
		
	}
	@Test
	public void blockAccount_ShouldReturnHttpStatusOK_WhenDataValid() {
		when(accountRepository.findById(1)).thenReturn(Optional.of(initialAccount));
		when(initialAccount.isBlocked()).thenReturn(false);
		ResponseEntity<?> result = accountServiceImpl.blockAccount(1);
		verify(initialAccount).setBlocked(true);
		assertThat(result.getStatusCode(), is(HttpStatus.OK));
	}
	@Test
	public void blockAccount_ShouldThrowResourceNotFoundException_WhenAccountIdNotFound() {
		when(accountRepository.findById(1)).thenReturn(Optional.empty());
		ResourceNotFoundException exception = Assertions.assertThrows(ResourceNotFoundException.class, 
				() -> accountServiceImpl.updateAccount(dtoUpdate, 1));
        assertThat(exception.getMessage(), is("Account not found"));
	}
	@Test
	public void blockAccount_ShouldReturnHttpStatus400_WhenAccountDeletedBefore() {
		when(accountRepository.findById(1)).thenReturn(Optional.of(initialAccount));
		when(initialAccount.isBlocked()).thenReturn(true);
		ResponseEntity<?> result = accountServiceImpl.blockAccount(1);
		assertThat(result.getStatusCode(), is(HttpStatus.BAD_REQUEST));
	}
}
