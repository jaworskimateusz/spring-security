package com.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

	@GetMapping("/")
	public String showHomePage() {
		return "home";
	}
	
	@GetMapping("/enemy")
	public String showEnemyPage() {
		return "enemy";
	}
	
	@GetMapping("/crew")
	public String showCrewPage() {
		return "crew";
	}
	
}
