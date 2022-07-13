package com.example.demo.services;

import org.springframework.http.ResponseEntity;

import com.example.demo.data.dto.AccountUpdateDto;
import com.example.demo.data.entities.AccountEntity;
import com.example.demo.request.RegisterRequest;

public interface AccountService {
	public AccountEntity addAccount(RegisterRequest dto);
	public ResponseEntity<?> updateAccount(AccountUpdateDto dto, Integer accoutnId);
	public ResponseEntity<?> blockAccount(Integer accountId);
	public ResponseEntity<?> getInformation(Integer accountId);
}
