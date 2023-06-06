package com.challange.alura.forum.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
public class HelloController {
	@GetMapping
	public String hello() {
		return "funcionou";
	}
}
