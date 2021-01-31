package com.mitocode.jwd.examen.patient.application;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mitocode.jwd.examen.patient.domain.Patient;
import com.mitocode.jwd.examen.patient.domain.PatientRepository;
import com.mitocode.jwd.examen.patient.domain.exception.PatientNotFoundException;

@Service
public class PatientFinderService {

	private PatientRepository patientRepository;

	public PatientFinderService(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}

	public Optional<Patient> findByDni(String dni) throws PatientNotFoundException {
		return Optional.ofNullable(patientRepository.findByDni(dni).orElseThrow(PatientNotFoundException::new));
	}
}
