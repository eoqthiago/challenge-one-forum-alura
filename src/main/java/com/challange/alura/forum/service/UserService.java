package com.challange.alura.forum.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	public static String encoder(String password) {
		BCryptPasswordEncoder encodePassword = new BCryptPasswordEncoder();
		return encodePassword.encode(password);
	}
}
