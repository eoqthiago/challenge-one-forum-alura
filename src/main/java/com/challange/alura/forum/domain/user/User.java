package com.challange.alura.forum.domain.user;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.challange.alura.forum.domain.user.dto.Create;
import com.challange.alura.forum.domain.user.dto.UpdateUser;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Entity(name = "User")
@Table(name = "users")
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Data
public class User implements UserDetails {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String password;
	
	public User() {
	}
	
	public User(Create data) {
		this.name = data.name();
		this.email = data.email();
		this.password = data.password();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public String getUsername() {
		return email;
	}
	
	@Override
	public String getPassword() {
		return password;
	}
	
	public Long getId() {
		return id;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public void update(UpdateUser data) {
		System.out.println("entrou aq");
		if(data.name() != null) {
			this.name = data.name();
		}
		if(data.email() != null) {
			this.email = data.email();
		}
		if(data.password() != null) {
			this.password = data.password();
		}
		System.out.println();
	}
}
