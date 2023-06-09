package com.challange.alura.forum.domain.course;

import com.challange.alura.forum.domain.course.dto.CreateCourse;
import com.challange.alura.forum.domain.course.dto.UpdateCourse;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
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

	public void update(@Valid UpdateCourse data) {
		if(data.name() != null) {
			this.name = data.name();
		}
		if(data.category() != null) {
			this.category = data.category();
		}
		
	}
	

	
	
}
