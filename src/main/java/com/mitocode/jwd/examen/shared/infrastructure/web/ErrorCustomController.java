package com.mitocode.jwd.examen.shared.infrastructure.web;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorCustomController implements ErrorController {

	@GetMapping("/error")
	public String handleError() {
		//TODO: Completar los demas errores
		
		return "error/error";
	}
	
	@Override
	public String getErrorPath() {
		return "error/";
	}

}
