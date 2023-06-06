package com.challange.alura.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challange.alura.forum.domain.user.dto.Login;

@RestController
@RequestMapping("/login")
public class AuthController {
	
	
	@PostMapping
	public String login(@RequestBody Login login) {
		return "Login";
	}
}
