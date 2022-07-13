package com.example.demo.controllers.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.dto.AccountUpdateDto;
import com.example.demo.services.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {
	@Autowired
	AccountService accountService;
	
	@PutMapping("/{accountId}")
	public ResponseEntity<?> updateAccount(@PathVariable Integer accountId, 
			@Valid @RequestBody AccountUpdateDto dto){
		return accountService.updateAccount(dto, accountId);
	}
	
	
	@DeleteMapping("/{accountId}")
	public ResponseEntity<?> blockAccount(@PathVariable Integer accountId){
		return accountService.blockAccount(accountId);
	}
	@GetMapping("/{accountId}")
	public ResponseEntity<?> getInformation(@PathVariable Integer accountId){
		return accountService.getInformation(accountId);
	}
}
