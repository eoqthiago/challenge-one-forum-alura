package com.challange.alura.forum.domain.user;

import com.challange.alura.forum.domain.user.dto.Create;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;


@Entity(name = "User")
@Table(name = "users")
@AllArgsConstructor
@Data
public class User {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String password;
	
	public User(Create data) {
		this.name = data.name();
		this.email = data.email();
		this.password = data.password();
	}
}
