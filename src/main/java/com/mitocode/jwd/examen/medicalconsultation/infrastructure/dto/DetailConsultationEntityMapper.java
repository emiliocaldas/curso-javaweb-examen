package com.mitocode.jwd.examen.medicalconsultation.infrastructure.dto;

import org.mapstruct.Context;
//import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;

import com.mitocode.jwd.examen.medicalconsultation.domain.DetailConsultation;
import com.mitocode.jwd.examen.medicalconsultation.infrastructure.persistence.DetailConsultationEntity;
import com.mitocode.jwd.examen.shared.infrastructure.dto.CycleAvoidingMappingContext;

@Mapper(componentModel = "spring", uses = { MedicalConsultationEntityMapper.class })
public interface DetailConsultationEntityMapper {

	// @Mapping(target = "medicalConsultation", ignore = true)
	DetailConsultation toDetailConsultation(DetailConsultationEntity entity,
			@Context CycleAvoidingMappingContext context);

	// @InheritInverseConfiguration
	DetailConsultationEntity toEntity(DetailConsultation detailConsultation,
			@Context CycleAvoidingMappingContext context);
}
