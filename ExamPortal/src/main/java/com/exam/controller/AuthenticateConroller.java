package com.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.config.JwtUtils;
import com.exam.entity.JwtRequest;
import com.exam.entity.JwtResponse;
import com.exam.helper.UserNotFoundException;
import com.exam.service.UserDetailsServiceImpl;

@RestController
public class AuthenticateConroller {

	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	
	//generate token
	@PostMapping("/generate-token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
		
		try {
			authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());
		} catch (UserNotFoundException e) {
			throw new Exception("User not found ");
		}
		
		UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(jwtRequest.getUsername());
		String token = jwtUtils.generateToken(userDetails);
		
		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	private void authenticate(String userName, String password) throws Exception {
		
		try {
			
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
			
		}catch (DisabledException e) {
			throw new Exception("User Disabled "+e.getMessage());
		}catch(BadCredentialsException e) {
			throw new Exception("Invalid Credentials "+e.getMessage());
		}
	}
}
