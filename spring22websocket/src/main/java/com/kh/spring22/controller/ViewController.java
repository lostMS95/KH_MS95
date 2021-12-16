package com.kh.spring22.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/basic")
	public String basic() {
		return "basic";
	}
	
	@GetMapping("/manage")
	public String manage() {
		return "manage";
	}
	@GetMapping("/message")
	public String message() {
		return "message";
	}
}
