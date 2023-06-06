package com.challange.alura.forum.domain.user.dto;

import jakarta.validation.constraints.NotBlank;

public record Create(
		@NotBlank
		String name,
		@NotBlank
		String email,
		@NotBlank
		String password
		) {

}
