package com.mitocode.jwd.examen.patient.infrastructure.persistence;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.mitocode.jwd.examen.patient.domain.Patient;
import com.mitocode.jwd.examen.patient.domain.PatientRepository;
import com.mitocode.jwd.examen.patient.infrastructure.dto.PatientEntityMapper;
import com.mitocode.jwd.examen.shared.infrastructure.dto.CycleAvoidingMappingContext;

@Repository
public class PatientJpaRepository implements PatientRepository {

	private PatientCrudRepository patientCrudRepository;
	private PatientEntityMapper patientEntityMapper;
	private CycleAvoidingMappingContext context;

	public PatientJpaRepository(PatientCrudRepository patientCrudRepository, PatientEntityMapper patientEntityMapper) {
		this.patientCrudRepository = patientCrudRepository;
		this.patientEntityMapper = patientEntityMapper;
	}

	@Override
	public int save(Patient patient) {
		context = new CycleAvoidingMappingContext();
		PatientEntity entity = patientCrudRepository.save(patientEntityMapper.toEntity(patient, context));
		patient.setId(entity.getId());

		return entity == null ? 0 : 1;
	}

	@Override
	public Optional<Patient> findByDni(String dni) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Patient> findById(Integer id) {
		context = new CycleAvoidingMappingContext();
		
		return patientCrudRepository.findById(id).map(entity -> patientEntityMapper.toPatient(entity, context));
	}

}
