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
import com.challange.alura.forum.domain.course.dto.CreateCourse;
import com.challange.alura.forum.domain.course.dto.DetailsCourse;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/courses")
public class CourseController {
	
	@Autowired
	private CourseRepository repository;
	
	@PostMapping
	@Transactional
	public ResponseEntity createCourse(@RequestBody @Valid CreateCourse data, UriComponentsBuilder builder) {
		var course = new Course(data);
		repository.save(course);
		var uri = builder.path("/courses/{id}").buildAndExpand(course.getId()).toUri();
		return ResponseEntity.created(uri).body(new DetailsCourse(course));
		
	}
}
