package com.example.demo.services;

import org.springframework.http.ResponseEntity;

import com.example.demo.request.LoginRequest;
import com.example.demo.request.SignupRequest;

public interface AuthService {
	public ResponseEntity<?> authenticateUser(LoginRequest loginRequest);
	public ResponseEntity<?> signup(SignupRequest signupRequest);
}
