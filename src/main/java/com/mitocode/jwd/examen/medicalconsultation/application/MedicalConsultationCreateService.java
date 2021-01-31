package com.mitocode.jwd.examen.medicalconsultation.application;

import org.springframework.stereotype.Service;

import com.mitocode.jwd.examen.medicalconsultation.domain.MedicalConsultation;
import com.mitocode.jwd.examen.medicalconsultation.domain.MedicalConsultationRepository;

@Service
public class MedicalConsultationCreateService {

	private MedicalConsultationRepository medicalConsultationRepository;

	public MedicalConsultationCreateService(MedicalConsultationRepository medicalConsultationRepository) {
		this.medicalConsultationRepository = medicalConsultationRepository;
	}

	public int save(MedicalConsultation medicalConsultation) {
		int rows = medicalConsultationRepository.save(medicalConsultation);
		
		return rows;
	}
}
