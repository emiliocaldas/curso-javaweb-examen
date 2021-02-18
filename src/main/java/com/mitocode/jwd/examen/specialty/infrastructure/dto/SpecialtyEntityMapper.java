package com.mitocode.jwd.examen.specialty.infrastructure.dto;

import org.mapstruct.Context;
import org.mapstruct.Mapper;

import com.mitocode.jwd.examen.doctor.infrastructure.dto.DoctorEntityMapper;
import com.mitocode.jwd.examen.shared.infrastructure.dto.CycleAvoidingMappingContext;
import com.mitocode.jwd.examen.specialty.domain.Specialty;
import com.mitocode.jwd.examen.specialty.infrastructure.persistence.SpecialtyEntity;

@Mapper(componentModel = "spring", uses = { DoctorEntityMapper.class })
public interface SpecialtyEntityMapper {

	Specialty toSpecialty(SpecialtyEntity entity, @Context CycleAvoidingMappingContext context);

	SpecialtyEntity toEntity(Specialty specialty, @Context CycleAvoidingMappingContext context);
}
