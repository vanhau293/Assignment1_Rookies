package com.example.demo.security.services;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.data.entities.AccountEntity;
import com.example.demo.data.repositories.AccountRepository;
import com.example.demo.exceptions.UnauthorizedException;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AccountRepository accountRepository;

    public UserDetailsServiceImpl (AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
    	//
    	// user name lúc login là "usename encode(password)"
    	String[] thongtin = username.split(" "); // index 0: username 1: password
    	Optional<AccountEntity> optional = accountRepository.findByUserName(thongtin[0]);
    	if(!optional.isPresent()) {
    		throw new UnauthorizedException("Username is not found");
    	}
        AccountEntity user = optional.get();
        if(thongtin.length > 1 && !BCrypt.checkpw(thongtin[1],user.getPassword())) {
        	throw new UnauthorizedException("Password is wrong");
        }
        return UserDetailsImpl.build(user);
    }
    
    public UserDetails loadUser(String username, String password) {
    	Optional<AccountEntity> optional = accountRepository.findByUserName(username);
    	if(!optional.isPresent()) {
    		throw new UnauthorizedException("Invalid token: username");
    	}
        AccountEntity user = optional.get();
        if(!user.getPassword().equals(password)) {
        	throw new UnauthorizedException("Invalid token: password");
        }
        return UserDetailsImpl.build(user);

    }
}
