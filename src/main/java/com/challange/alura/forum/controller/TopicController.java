package com.challange.alura.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.challange.alura.forum.domain.course.Course;
import com.challange.alura.forum.domain.course.CourseRepository;
import com.challange.alura.forum.domain.topic.Topic;
import com.challange.alura.forum.domain.topic.TopicRepository;
import com.challange.alura.forum.domain.topic.dto.CreateTopic;
import com.challange.alura.forum.domain.topic.dto.DetailsTopic;
import com.challange.alura.forum.domain.user.User;
import com.challange.alura.forum.domain.user.UserRepository;
import com.challange.alura.forum.service.UserService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/topics")
public class TopicController {
	
	@Autowired
	private TopicRepository repository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity createTopic (@RequestBody @Valid CreateTopic data, UriComponentsBuilder builder) {		
		var topic = new Topic(data);
		String hashCode = UserService.encoder(topic.getUser().getPassword());
		topic.getUser().setPassword(hashCode);
		repository.save(topic);
		var uri = builder.path("topics/{id}").buildAndExpand(topic.getId()).toUri();
		return ResponseEntity.created(uri).body(new DetailsTopic(topic));
	}
}
