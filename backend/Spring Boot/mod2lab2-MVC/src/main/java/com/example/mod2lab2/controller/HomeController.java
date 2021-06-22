package com.example.mod2lab2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("message", "Spring Boot + Thyneleaf rocks");
		return "home";
	}
}
