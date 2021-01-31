package com.mitocode.jwd.examen.medicalconsultation.infrastructure.dto;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.mitocode.jwd.examen.medicalconsultation.domain.DetailConsultation;
import com.mitocode.jwd.examen.medicalconsultation.infrastructure.persistence.DetailConsultationEntity;

@Mapper(componentModel = "spring")
public interface DetailConsultationEntityMapper {

	@Mapping(target = "medicalConsultation", ignore = true)
	DetailConsultation toDetailConsultation(DetailConsultationEntity entity);

	@InheritInverseConfiguration
	DetailConsultationEntity toEntity(DetailConsultation detailConsultation);
}
