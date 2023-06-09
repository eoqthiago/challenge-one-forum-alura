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

import com.challange.alura.forum.domain.user.User;
import com.challange.alura.forum.domain.user.UserRepository;
import com.challange.alura.forum.domain.user.dto.Create;
import com.challange.alura.forum.domain.user.dto.DataDetail;
import com.challange.alura.forum.domain.user.dto.UpdateUser;
import com.challange.alura.forum.service.UserService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity create(@RequestBody @Valid Create data, UriComponentsBuilder builder) {
		var user = new User(data);
		userRepository.save(user);
		var uri = builder.path("users/{id}").buildAndExpand(user.getId()).toUri();
		String hashCode = UserService.encoder(user.getPassword());
		user.setPassword(hashCode);
		return ResponseEntity.created(uri).body(new DataDetail(user));
		
	}
	
	@GetMapping
	public ResponseEntity<Page<DataDetail>> findAll(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
		var user = userRepository.findAll();
		return ResponseEntity.ok(userRepository.findAll(pageable).map(DataDetail::new));
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity update(@RequestBody @Valid UpdateUser data) {
		var user = userRepository.getReferenceById(data.id());
		user.update(data);
		return ResponseEntity.ok(new DataDetail(user));
		
	}
}
