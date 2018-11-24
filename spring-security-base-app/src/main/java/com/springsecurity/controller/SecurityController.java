package com.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {
	
	@GetMapping("/")
	public String showHomePage() {
		return "home";
	}
	
	@GetMapping("/leaders")
	public String showLeadersPage() {
		return "leaders";
	}
	
	@GetMapping("/systems")
	public String showSystemsPage() {
		return "systems";
	}

}
