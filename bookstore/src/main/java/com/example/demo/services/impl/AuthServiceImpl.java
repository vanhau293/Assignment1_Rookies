package com.example.demo.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.data.entities.AccountEntity;
import com.example.demo.data.entities.RoleEntity;
import com.example.demo.repositories.AccountRepository;
import com.example.demo.repositories.RoleRepository;
import com.example.demo.request.LoginRequest;
import com.example.demo.request.SignupRequest;
import com.example.demo.response.JwtResponse;
import com.example.demo.response.MessageResponse;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.security.jwt.JwtUtils;
import com.example.demo.security.services.UserDetailsImpl;
import com.example.demo.services.AuthService;
@Service
public class AuthServiceImpl implements AuthService{
	private AuthenticationManager authenticationManager;
	private AccountRepository accountRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder encoder;
    private JwtUtils jwtUtils;
        
    @Autowired
    public AuthServiceImpl (AuthenticationManager authenticationManager, AccountRepository accountRepository,
                           RoleRepository roleRepository, PasswordEncoder encoder, JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.accountRepository = accountRepository;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
        this.jwtUtils = jwtUtils;
    }
	
	@Override
	public ResponseEntity<?> authenticateUser(LoginRequest loginRequest) {
		// TODO Auto-generated method stub
		Authentication authentication = authenticationManager.authenticate(
	            new UsernamePasswordAuthenticationToken(loginRequest.getUsername()+" "+loginRequest.getPassword(), loginRequest.getPassword()));
	      
	        // if go there, the user/password is correct
	        SecurityContextHolder.getContext().setAuthentication(authentication);
	        // generate jwt to return to client
	        
	        String jwt = jwtUtils.generateJwtToken(authentication);
	        
	        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
	        List<String> roles = userDetails.getAuthorities().stream()
	            .map(item -> item.getAuthority())
	            .collect(Collectors.toList());
	        return ResponseEntity.ok(new JwtResponse(jwt,
	                                                 userDetails.getId(),
	                                                 userDetails.getUsername(),
	                                                 roles.get(0)));
	}
	@Override
	public ResponseEntity<?> signup(SignupRequest signUpRequest) {
		// TODO Auto-generated method stub
		Optional<AccountEntity> optionalAcc = accountRepository.findByUserName(signUpRequest.getUsername());
        if (optionalAcc.isPresent()){
            return ResponseEntity
                .badRequest()
                .body(new MessageResponse("Error: Username is already taken!"));
        }

        // Create new user's account
        AccountEntity user = new AccountEntity(signUpRequest.getUsername(),
                             encoder.encode(signUpRequest.getPassword()));

        String role = signUpRequest.getRole();

        Optional<RoleEntity> optional =  roleRepository.findById(Integer.parseInt(role));
        if(optional.isPresent()) {
        	RoleEntity r = optional.get();
        	user.setRoleId(r);
        	accountRepository.save(user);

            return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
        }
        throw new ResourceNotFoundException("Role not found");
	}

}
