package com.mitocode.jwd.examen.medicalconsultation.infrastructure.dto;

import org.mapstruct.Context;
import org.mapstruct.Mapper;

import com.mitocode.jwd.examen.doctor.infrastructure.dto.DoctorEntityMapper;
import com.mitocode.jwd.examen.medicalconsultation.domain.MedicalConsultation;
import com.mitocode.jwd.examen.medicalconsultation.infrastructure.persistence.MedicalConsultationEntity;
import com.mitocode.jwd.examen.patient.infrastructure.dto.PatientEntityMapper;
import com.mitocode.jwd.examen.shared.infrastructure.dto.CycleAvoidingMappingContext;

@Mapper(componentModel = "spring", uses = { DoctorEntityMapper.class, PatientEntityMapper.class,
		DetailConsultationEntityMapper.class })
public interface MedicalConsultationEntityMapper {

	MedicalConsultation toMedicalConsultation(MedicalConsultationEntity entity,
			@Context CycleAvoidingMappingContext context);

	MedicalConsultationEntity toEntity(MedicalConsultation medicalConsultation,
			@Context CycleAvoidingMappingContext context);
}
