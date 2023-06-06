package com.challange.alura.forum.domain.user.dto;

import com.challange.alura.forum.domain.user.User;

public record DataDetail(Long id, String name, String email) {
	
	public DataDetail(User user) {
		this(user.getId(), user.getName(), user.getEmail());
	}
}
