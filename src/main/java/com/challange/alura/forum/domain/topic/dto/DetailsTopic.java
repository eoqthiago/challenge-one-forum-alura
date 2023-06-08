package com.challange.alura.forum.domain.topic.dto;

import com.challange.alura.forum.domain.topic.Topic;
import com.challange.alura.forum.domain.user.User;

import java.time.LocalDateTime;

import com.challange.alura.forum.domain.course.Course;
import com.challange.alura.forum.domain.topic.Status;

public record DetailsTopic(Long id, String title, String message, Status status, LocalDateTime creationDate,  User user, Course course) {
	
	public DetailsTopic(Topic topic) {
		this(topic.getId(), topic.getTitle(), topic.getMessage(), topic.getStatus(), topic.getCreationDate(), topic.getUser(), topic.getCourse());
	}
}
