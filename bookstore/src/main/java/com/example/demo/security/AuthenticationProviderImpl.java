package com.example.demo.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.authentication.AuthenticationProvider;
public class AuthenticationProviderImpl implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		String username = authentication.getPrincipal().toString(); // (1)
      String password = authentication.getCredentials().toString(); // (1)
      System.out.println(username + " "+ password);
      return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return false;
	}

//    Authentication authenticate(Authentication authentication)  // (1)
//            throws AuthenticationException {
//        String username = authentication.getPrincipal().toString(); // (1)
//        String password = authentication.getCredentials().toString(); // (1)
//
//        User user = callAtlassianCrowdRestService(username, password); // (2)
//        if (user == null) {                                     // (3)
//            throw new AuthenticationException("could not login");
//        }
//        return new UserNamePasswordAuthenticationToken(user.getUsername(), user.getPassword()); // (4)
//    }

}
