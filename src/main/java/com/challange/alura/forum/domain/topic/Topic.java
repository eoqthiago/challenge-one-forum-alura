package com.challange.alura.forum.domain.topic;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.challange.alura.forum.domain.course.Course;
import com.challange.alura.forum.domain.replies.Replies;
import com.challange.alura.forum.domain.topic.dto.CreateTopic;
import com.challange.alura.forum.domain.user.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity(name = "Topic")
@Table(name = "topics")
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Data
public class Topic {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	private String message;
	@JoinColumn(name = "creation_date")
	private LocalDateTime creationDate;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "author_id")
	private User user;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "course_id")
	private Course course;
	
	public Topic() {
	}
	
	public Topic(CreateTopic data) {

		this.title = data.title();
		this.message = data.message();
		this.creationDate = LocalDateTime.now();
		this.status = data.status();
		this.user = new User(data.author());
		this.course = new Course(data.course());
		
	}
	
	
	
	
}
