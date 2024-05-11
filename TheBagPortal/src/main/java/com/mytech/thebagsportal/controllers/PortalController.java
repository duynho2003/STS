package com.mytech.thebagsportal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mytech.thebagsservice.entities.User;

@Controller
public class PortalController {
	
	@GetMapping("/")
	public String getHome() {
		return "index";
	}
	
	@GetMapping("/login")
	public String getLogin(Model model) {
		User user = new User();
		
		model.addAttribute("user", user);
		
		return "authentication/sign-in";
}
	
	
}
