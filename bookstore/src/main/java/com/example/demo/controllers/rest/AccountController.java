package com.example.demo.controllers.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.request.AccountUpdateRequestDto;
import com.example.demo.services.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {
	@Autowired
	AccountService accountService;
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateAccount(@PathVariable Integer accountId, 
			@Valid @RequestBody AccountUpdateRequestDto dto){
		return accountService.updateAccount(dto, accountId);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteAccount(@PathVariable Integer accountId){
		return accountService.blockAccount(accountId);
	}
}
