package com.challange.alura.forum.domain.topic.dto;


import com.challange.alura.forum.domain.topic.Status;

import jakarta.validation.constraints.NotNull;

public record UpdateTopic(
		@NotNull
		Long id,
		String title,
		String message,
		Status status
		) {

}
