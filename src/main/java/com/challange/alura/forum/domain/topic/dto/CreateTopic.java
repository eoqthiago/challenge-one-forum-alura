package com.challange.alura.forum.domain.topic.dto;

import com.challange.alura.forum.domain.course.dto.CreateCourse;
import com.challange.alura.forum.domain.topic.Status;
import com.challange.alura.forum.domain.user.dto.Create;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateTopic(
		@NotBlank
		String title,
		@NotBlank
		String message,
		Status status,
		@NotNull @Valid
		Create author,
		@NotNull @Valid
		CreateCourse course
		) {

}
