package com.challange.alura.forum.domain.course.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateCourse(
		@NotNull
		Long id,
		String name,
		String category
		) {

}
