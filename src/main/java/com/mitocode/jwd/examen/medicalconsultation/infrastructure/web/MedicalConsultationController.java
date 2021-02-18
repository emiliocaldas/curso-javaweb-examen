package com.mitocode.jwd.examen.medicalconsultation.infrastructure.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/medicalconsultation")
public class MedicalConsultationController {

	@GetMapping("/create")
	public String create() {
		
		return "medicalconsultation/medicalconsultation-create";
	}
}
