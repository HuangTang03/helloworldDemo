package com.example.gethelloworld.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
	public  class GetHelloWorldController {
		@GetMapping("/helloWorld")
		@PreAuthorize("hasAuthority('YourController:YourMethod')")
		public String hello() {
			return "Hello world";
		}
	}