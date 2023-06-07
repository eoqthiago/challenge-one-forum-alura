package com.challange.alura.forum.service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.challange.alura.forum.domain.user.User;

@Service
public class TokenService {
	
	@Value("${api.security.token.secret}")
	private String secret;

	public String generateToken(User user) {
		try {
			return JWT.create()
					.withIssuer("usuario")
					.withSubject(user.getEmail())
					.withClaim("id", user.getId())
					.withExpiresAt(LocalDateTime.now()
							.plusMinutes(10)
							.toInstant(ZoneOffset.of("-03:00"))
					).sign(Algorithm.HMAC256(secret));
			
		} catch (JWTCreationException exception) {
			throw new RuntimeException("Error token", exception);
		}
	
	}

	public String getSubject(String token) {
		try {
			var algorithm = Algorithm.HMAC256(secret);
			return JWT.require(algorithm)
					.withIssuer("usuario")
					.build()
					.verify(token)
					.getSubject();
			
		} catch (Exception e) {
			throw new RuntimeException("Token invalid or expired");
		}
	}

}
