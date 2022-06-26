package com.example.demo.services;

import org.springframework.http.ResponseEntity;

import com.example.demo.data.entities.AccountEntity;
import com.example.demo.dto.request.AccountUpdateRequestDto;
import com.example.demo.dto.request.RegisterRequestDto;

public interface AccountService {
	public AccountEntity addAccount(RegisterRequestDto dto);
	public ResponseEntity<?> updateAccount(AccountUpdateRequestDto dto, Integer accoutnId);
	public ResponseEntity<?> blockAccount(Integer accountId);
}
