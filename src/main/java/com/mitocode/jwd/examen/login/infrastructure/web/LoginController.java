package com.mitocode.jwd.examen.login.infrastructure.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/login")
	//public String login(LoginForm loginForm) {
	public String login() {
		//loginForm.setUsername("juanpablo@mitocodenetwork.com");

		return "login/login";
	}

}
