package com.challange.alura.forum.domain.course;

import com.challange.alura.forum.domain.course.dto.CreateCourse;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity(name = "Course")
@Table(name = "courses")
@AllArgsConstructor
@Data
@EqualsAndHashCode(of = "id")
public class Course {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String category;
	
	public Course() {
	}

	public Course(CreateCourse course) {
		this.name = course.name();
		this.category = course.category();
	}
	

	
	
}
