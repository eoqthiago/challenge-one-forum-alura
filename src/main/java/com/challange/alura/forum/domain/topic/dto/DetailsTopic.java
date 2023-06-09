package com.challange.alura.forum.domain.topic.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.challange.alura.forum.domain.course.Course;
import com.challange.alura.forum.domain.topic.Status;
import com.challange.alura.forum.domain.topic.Topic;
import com.challange.alura.forum.domain.user.User;

public record DetailsTopic(Long id, String title, String message, Status status, LocalDateTime creationDate, UserSummary userSummary, CourseSummary course) {
	
	private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	
	public DetailsTopic(Topic topic) {
		this(topic.getId(), topic.getTitle(), topic.getMessage(), topic.getStatus(),
			topic.getCreationDate(),  
			topic.getUser() != null ? new UserSummary(topic.getUser()) : null,
		    topic.getCourse() != null ? new CourseSummary(topic.getCourse()) : null);
	}
	
	 public record UserSummary(Long id, String name, String email) {
		 public UserSummary(User user) {
			 this(user.getId(), user.getName(), user.getEmail());
		 }
	 }

	  record CourseSummary(Long id, String name, String category) {
	     public CourseSummary(Course course) {
	    	 this(course.getId(), course.getName(), course.getCategory());
	     }
	 }
	  
	 public String getCreationDate() {
	    return creationDate.format(dateFormatter);
	 }
}
