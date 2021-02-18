package com.mitocode.jwd.examen.patient.application;

import org.springframework.stereotype.Service;

import com.mitocode.jwd.examen.patient.domain.Patient;
import com.mitocode.jwd.examen.patient.domain.PatientRepository;

@Service
public class PatientCreateService {

	private PatientRepository patientRepository;

	public PatientCreateService(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}

	public int save(Patient patient) {
		int rows = patientRepository.save(patient);

		return rows;
	}

}
