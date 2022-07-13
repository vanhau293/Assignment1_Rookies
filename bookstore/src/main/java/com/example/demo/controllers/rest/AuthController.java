package com.example.demo.controllers.rest;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.entities.AccountEntity;
import com.example.demo.request.LoginRequest;
import com.example.demo.request.RegisterRequest;
import com.example.demo.request.SignupRequest;
import com.example.demo.services.AccountService;
import com.example.demo.services.AuthService;
import com.example.demo.services.CustomerService;


@RestController
@RequestMapping("/auth")
public class AuthController {

	private PasswordEncoder encoder;
    private AccountService accountService;
    private CustomerService customerService;
    private AuthService authService;
    
    @Autowired
    public AuthController (PasswordEncoder encoder, AccountService accountService,CustomerService customerService, AuthService authService) {
        this.encoder = encoder;
        this.accountService = accountService; 
        this.customerService = customerService;
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
    	return authService.authenticateUser(loginRequest);
    }
    @PostMapping("/register") // đăng ký tài khoản cả thông tin khách hàng
    @Transactional
    public ResponseEntity<?> registerAccountEmployee(@Valid @RequestBody RegisterRequest dto){
    	dto.setPassword(encoder.encode(dto.getPassword()));
    	AccountEntity account = accountService.addAccount(dto);
    	return customerService.addCustomer(dto, account);
    }
    
    @PostMapping("/signup") // đăng ký mọi tài khoản không thêm thông tin vào bảng khách hoặc nhân viên
    public ResponseEntity<?> signupUser(@Valid @RequestBody SignupRequest signUpRequest) {
    	return authService.signup(signUpRequest);
    }
}