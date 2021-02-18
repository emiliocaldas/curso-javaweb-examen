package com.mitocode.jwd.examen.doctor.infrastructure.dto;

import org.mapstruct.Context;
import org.mapstruct.Mapper;

import com.mitocode.jwd.examen.doctor.domain.Doctor;
import com.mitocode.jwd.examen.doctor.infrastructure.persistence.DoctorEntity;
import com.mitocode.jwd.examen.shared.infrastructure.dto.CycleAvoidingMappingContext;
import com.mitocode.jwd.examen.specialty.infrastructure.dto.SpecialtyEntityMapper;

@Mapper(componentModel = "spring", uses = { SpecialtyEntityMapper.class })
public interface DoctorEntityMapper {

	Doctor toDoctor(DoctorEntity entity, @Context CycleAvoidingMappingContext context);

	DoctorEntity toEntity(Doctor doctor, @Context CycleAvoidingMappingContext context);
}
