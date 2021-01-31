package com.mitocode.jwd.examen.patient.domain;

import java.util.Optional;

public interface PatientRepository {

	public Optional<Patient> findByDni(String dni);
}
