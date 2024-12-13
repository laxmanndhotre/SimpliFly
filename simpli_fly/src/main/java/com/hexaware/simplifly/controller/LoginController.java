package com.hexaware.simplifly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	@CrossOrigin(origins = "http://localhost:4200") 
    @GetMapping("/login")
    public String login() {
        return "login"; // Return the name of the login page template
    }
}