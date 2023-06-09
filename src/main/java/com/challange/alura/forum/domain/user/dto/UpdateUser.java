package com.challange.alura.forum.domain.user.dto;

import jakarta.validation.constraints.NotNull;

public record UpdateUser(
		@NotNull
		Long id,
		String name,
		String email,
		String password
		) {

}
