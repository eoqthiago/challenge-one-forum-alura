package com.challange.alura.forum.domain.replies;

import java.time.LocalDateTime;

import com.challange.alura.forum.domain.topic.Topic;
import com.challange.alura.forum.domain.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity(name = "Replies")
@Table(name = "replies")
@AllArgsConstructor
@Data
@EqualsAndHashCode(of = "id")
public class Replies {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String message;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Topic topic;
	
	private LocalDateTime creationDate = LocalDateTime.now();
	
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
	
	private Boolean solution = false;
	
	public Replies() {
		
	}
}
