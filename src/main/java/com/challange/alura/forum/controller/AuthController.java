package com.challange.alura.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challange.alura.forum.domain.user.User;
import com.challange.alura.forum.domain.user.dto.Login;
import com.challange.alura.forum.security.dto.TokenDetails;
import com.challange.alura.forum.service.TokenService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AuthController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity login(@RequestBody @Valid Login login) {
		var usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(login.login(), login.password());
		var authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
		System.out.println(authenticate);
		var user = tokenService.generateToken((User) authenticate.getPrincipal());
		System.out.println(user);
		
		return ResponseEntity.ok(new TokenDetails(user));
		
		
		
	}
}
