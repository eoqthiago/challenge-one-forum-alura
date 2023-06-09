package com.challange.alura.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.challange.alura.forum.domain.course.CourseRepository;
import com.challange.alura.forum.domain.topic.Topic;
import com.challange.alura.forum.domain.topic.TopicRepository;
import com.challange.alura.forum.domain.topic.dto.CreateTopic;
import com.challange.alura.forum.domain.topic.dto.DetailsTopic;
import com.challange.alura.forum.domain.topic.dto.UpdateTopic;
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
	
	@GetMapping
	public ResponseEntity<Page<DetailsTopic>> findAll(@PageableDefault(size = 10, sort = {"title"}) Pageable pageable) {
		System.out.println(pageable.getSort());
		return ResponseEntity.ok(repository.findAll(pageable).map(DetailsTopic::new));
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity update (@RequestBody @Valid UpdateTopic data) {
		var topic = repository.getReferenceById(data.id());
		topic.update(data);
		return ResponseEntity.ok(new DetailsTopic(topic));
	}
	
	
}
