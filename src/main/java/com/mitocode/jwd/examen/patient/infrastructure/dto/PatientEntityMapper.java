package com.mitocode.jwd.examen.patient.infrastructure.dto;

import org.mapstruct.Context;
import org.mapstruct.Mapper;

import com.mitocode.jwd.examen.medicalconsultation.infrastructure.dto.MedicalConsultationEntityMapper;
import com.mitocode.jwd.examen.patient.domain.Patient;
import com.mitocode.jwd.examen.patient.infrastructure.persistence.PatientEntity;
import com.mitocode.jwd.examen.shared.infrastructure.dto.CycleAvoidingMappingContext;

@Mapper(componentModel = "spring", uses = { MedicalConsultationEntityMapper.class })
public interface PatientEntityMapper {

	Patient toPatient(PatientEntity entity, @Context CycleAvoidingMappingContext context);

	PatientEntity toEntity(Patient patient, @Context CycleAvoidingMappingContext context);
}
