package com.mitocode.jwd.examen.specialty.infrastructure.dto;

import org.mapstruct.Mapper;

import com.mitocode.jwd.examen.doctor.infrastructure.dto.DoctorEntityMapper;
import com.mitocode.jwd.examen.specialty.domain.Specialty;
import com.mitocode.jwd.examen.specialty.infrastructure.persistence.SpecialtyEntity;

@Mapper(componentModel = "spring", uses = { DoctorEntityMapper.class })
public interface SpecialtyEntityMapper {

	Specialty toSpecialty(SpecialtyEntity entity);
	
	SpecialtyEntity toEntity(Specialty specialty);
}
