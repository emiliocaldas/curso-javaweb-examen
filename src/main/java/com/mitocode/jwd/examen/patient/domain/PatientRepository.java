package com.mitocode.jwd.examen.patient.domain;

import java.util.Optional;

public interface PatientRepository {

	public int save(Patient patient);

	public Optional<Patient> findById(Integer id);

	public Optional<Patient> findByDni(String dni);
}
