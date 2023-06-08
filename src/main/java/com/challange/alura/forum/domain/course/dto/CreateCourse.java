package com.challange.alura.forum.domain.course.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateCourse(
		@NotBlank
		String name,
		@NotBlank
		String category) {

}
