package com.challange.alura.forum.domain.course.dto;

import com.challange.alura.forum.domain.course.Course;

public record DetailsCourse(Long id, String name, String category) {

	public DetailsCourse(Course course) {
		this(course.getId(), course.getName(), course.getCategory());
	}
}
